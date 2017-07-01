package lab.aikibo.etc;

import lab.aikibo.entity.Passenger;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * Created by tamami on 27/06/17.
 */
public class BookingRecord {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String flightNumber;
    @Getter @Setter
    private String origin;
    @Getter @Setter
    private String destination;
    @Getter @Setter
    private String flightDate;
    @Getter @Setter
    private Date bookingDate;
    @Getter @Setter
    private String fare;
    @Getter @Setter
    private String status;
    @Getter @Setter
    private Set<Passenger> passengers;

    public BookingRecord() {}

    public BookingRecord(String flightNumber, String from, String to, String flightDate, Date bookingDate,
                         String fare) {
        this.flightNumber = flightNumber;
        this.origin = from;
        this.destination = to;
        this.flightDate = flightDate;
        this.bookingDate = bookingDate;
        this.fare = fare;
    }

    public String toString() {
        return "BookingRecord [id=" + id + ", flightNumber=" + flightNumber + ", from=" + origin + ", to=" + destination +
            ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", passenger=" + passengers + "]";
    }
}
