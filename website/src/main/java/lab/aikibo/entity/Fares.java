package lab.aikibo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tamami on 27/06/17.
 */
public class Fares {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String fare;
    @Getter @Setter
    private String currency;

    public Fares() { super(); }

    public Fares(String fare, String currency) {
        super();
        this.fare = fare;
        this.currency = currency;
    }

    public String toString() {
        return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
    }

}
