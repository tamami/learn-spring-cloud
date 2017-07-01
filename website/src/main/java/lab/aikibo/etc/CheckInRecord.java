package lab.aikibo.etc;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by tamami on 27/06/17.
 */
public class CheckInRecord {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String seatNumber;
    @Getter @Setter
    private Date checkInTime;
    @Getter @Setter
    private String flightNumber;
    @Getter @Setter
    private String flightDate;
    @Getter @Setter
    private long bookingId;

    public CheckInRecord() {}

    public CheckInRecord(String lastName, String firstName, String seatNumber, Date checkInTime, String flightNumber,
                         String flightDate, long bookingId) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.seatNumber = seatNumber;
        this.checkInTime = checkInTime;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.bookingId = bookingId;
    }

    public String toString() {
        return "CheckInRecord [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", seatNumber=" +
            seatNumber + ", checkInTime=" + checkInTime + ", flightNumber=" + flightNumber + ", flightDate=" +
            flightDate + "]";
    }
}
