package lab.aikibo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by tamami on 02/07/17.
 */

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private long id;
    @Setter @Getter @NonNull
    private String flightNumber;
    @Setter @Getter @NonNull
    private String flightDate;
    @Setter @Getter @NonNull
    private String fare;

}
