package lab.aikibo;

import lab.aikibo.component.BookingComponent;
import lab.aikibo.entity.BookingRecord;
import lab.aikibo.entity.Inventory;
import lab.aikibo.entity.Passenger;
import lab.aikibo.repo.BookingRepository;
import lab.aikibo.repo.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class BookApp implements CommandLineRunner
{

    private static final Logger logger = LoggerFactory.getLogger(BookApp.class);

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingComponent bookingComponent;

    @Autowired
    InventoryRepository inventoryRepository;

    public static void main( String[] args )
    {
        SpringApplication.run(BookApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Inventory[] invs = {
            new Inventory("BF100", "22-JAN-16", 100),
            new Inventory("BF101", "22-JAN-16", 100),
            new Inventory("BF102", "22-JAN-16", 100),
            new Inventory("BF103", "22-JAN-16", 100),
            new Inventory("BF104", "22-JAN-16", 100),
            new Inventory("BF105", "22-JAN-16", 100),
            new Inventory("BF106", "22-JAN-16", 100)
        };

        BookingRecord booking = new BookingRecord("BF101", "NYC", "SFO",
            "22-JAN-16", new Date(), "101");
        Set<Passenger> passengers = new HashSet<Passenger>();
        passengers.add(new Passenger("Gean", "Franc", "Male", booking));

        booking.setPassengers(passengers);
        long record = bookingComponent.book(booking);
        logger.info("Booking successfully saved..." + record);

        logger.info("Looking to load booking record...");
        logger.info("Result : " + bookingComponent.getBooking(record));
    }
}
