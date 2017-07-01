package lab.aikibo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tamami on 30/06/17.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"bookingId"})
public class CheckInRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;
    @Getter @Setter @NonNull
    private String lastName;
    @Getter @Setter @NonNull
    private String firstName;
    @Getter @Setter @NonNull
    private String seatNumber;
    @Getter @Setter @NonNull
    private Date checkInTime;
    @Getter @Setter @NonNull
    private String flightNumber;
    @Getter @Setter @NonNull
    private String flightDate;
    @Getter @Setter @NonNull
    private long bookingId;

}
