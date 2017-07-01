package lab.aikibo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by tamami on 28/06/17.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"fare", "status"})
public class BookingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;
    @Getter @Setter @NonNull
    private String flightNumber;
    @Getter @Setter @NonNull
    private String origin;
    @Getter @Setter @NonNull
    private String destination;
    @Getter @Setter @NonNull
    private String flightDate;
    @Getter @Setter @NonNull
    private Date bookingDate;
    @Getter @Setter @NonNull
    private String fare;
    @Getter @Setter
    private String status;
    @Getter @Setter
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bookingRecord")
    Set<Passenger> passengers;

}
