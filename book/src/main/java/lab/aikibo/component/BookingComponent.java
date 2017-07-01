package lab.aikibo.component;

import lab.aikibo.constant.BookingStatus;
import lab.aikibo.entity.BookingRecord;
import lab.aikibo.entity.Inventory;
import lab.aikibo.entity.Passenger;
import lab.aikibo.etc.Fare;
import lab.aikibo.exception.BookingException;
import lab.aikibo.repo.BookingRepository;
import lab.aikibo.repo.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tamami on 28/06/17.
 */
@Component
public class BookingComponent {

    private static final Logger logger = LoggerFactory.getLogger(BookingComponent.class);
    private static final String FareURL = "http://fare-apigateway/api/fares";

    BookingRepository bookingRepository;
    InventoryRepository inventoryRepository;

    private RestTemplate restTemplate;

    Sender sender;

    @Autowired
    public BookingComponent(BookingRepository bookingRepository, Sender sender, InventoryRepository inventoryRepository) {
        this.bookingRepository = bookingRepository;
        this.inventoryRepository = inventoryRepository;
        this.restTemplate = new RestTemplate();
        this.sender = sender;
    }

    public long book(BookingRecord record) {
        logger.info("calling fares to get fare");
        Fare fare = restTemplate.getForObject(FareURL + "/get?flightNumber=" + record.getFlightNumber() +
                "&flightDate=" + record.getFlightDate(), Fare.class);
        logger.info("calling fares to get fare " + fare);

        if(!record.getFare().equals(fare.getFare()))
            throw new BookingException("fare is tampered");
        logger.info("calling inventory to get inventory");

        Inventory inventory = inventoryRepository.findByFlightNumberAndFlightDate(record.getFlightNumber(),
            record.getFlightDate());
        if(!inventory.isAvailable(record.getPassengers().size())) {
            throw new BookingException("No more seats available");
        }
        logger.info("successfully checked inventory " + inventory);

        logger.info("calling inventory to update inventory");
        inventory.setAvailable(inventory.getAvailable() - record.getPassengers().size());
        inventoryRepository.saveAndFlush(inventory);
        logger.info("successfully updated inventory");

        record.setStatus(BookingStatus.BOOKING_CONFIRMED);
        Set<Passenger> passengers = record.getPassengers();
        passengers.forEach(passenger -> passenger.setBookingRecord(record));
        record.setBookingDate(new Date());

        long id = bookingRepository.save(record).getId();
        logger.info("Successfully saved booking");

        logger.info("sending a booking event");
        Map<String, Object> bookingDetails = new HashMap<String, Object>();
        bookingDetails.put("FLIGHT_NUMBER", record.getFlightNumber());
        bookingDetails.put("FLIGHT_DATE", record.getFlightDate());
        bookingDetails.put("NEW_INVENTORY", inventory.getBookableInventory());
        sender.sendSearch(bookingDetails);
        logger.info("booking event successfully delivered " + bookingDetails);

        return id;
    }

    public BookingRecord getBooking(long id) {
        return bookingRepository.findOne(id);
    }

    public void updateStatus(String status, long bookingId) {
        BookingRecord record = bookingRepository.findOne(bookingId);
        record.setStatus(status);
    }

}
