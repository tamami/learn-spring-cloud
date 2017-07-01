package lab.aikibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lab.aikibo.etc.BookingRecord;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by tamami on 27/06/17.
 */
public class Passenger {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String gender;

    @Getter @Setter
    @JsonIgnore
    private BookingRecord bookingRecord;

    public Passenger() {}

    public Passenger(String firstName, String lastName, String gender, BookingRecord bookingRecord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bookingRecord = bookingRecord;
    }

    public String toString() {
        return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
            ", gender=" + gender + "]";
    }

}
