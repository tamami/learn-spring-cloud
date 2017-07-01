package lab.aikibo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    @Getter @Setter
    private long id;
    @Getter @Setter @NonNull
    private String flightNumber;
    @Getter @Setter @NonNull
    private String flightDate;
    @Getter @Setter @NonNull
    private int available;

    public boolean isAvailable(int count) {
        return ((available - count) > 5);
    }

    public int getBookableInventory() {
        return available - 5;
    }

}
