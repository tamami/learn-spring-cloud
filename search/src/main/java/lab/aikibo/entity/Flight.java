package lab.aikibo.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by tamami on 28/06/17.
 */
@Entity
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Flight {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fare_id")
    @Getter @Setter @NonNull
    private Fares fares;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inv_id")
    @Getter @Setter @NonNull
    private Inventory inventory;

}
