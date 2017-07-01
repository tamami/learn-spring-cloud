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
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id")
    @Getter @Setter
    private long id;
    @Getter @Setter @NonNull
    private int count;


}

