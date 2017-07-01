package lab.aikibo.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by tamami on 28/06/17.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Fares {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @Column(name = "fare_id")
    private long id;
    @Getter @Setter @NonNull
    private String fare;
    @Getter @Setter @NonNull
    private String currency;

}
