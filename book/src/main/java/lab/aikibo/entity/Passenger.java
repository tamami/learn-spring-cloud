package lab.aikibo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Created by tamami on 28/06/17.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"bookingRecord"})
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private long id;
    @Getter @Setter @NonNull
    private String firstName;
    @Getter @Setter @NonNull
    private String lastName;
    @Getter @Setter @NonNull
    private String gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKING_ID")
    @JsonIgnore
    @Getter @Setter @NonNull
    private BookingRecord bookingRecord;


}
