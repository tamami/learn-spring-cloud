package lab.aikibo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tamami on 27/06/17.
 */
public class Flight {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String flightNumber;
    @Getter @Setter
    private String origin;
    @Getter @Setter
    private String destination;
    @Getter @Setter
    private String flightDate;
    @Getter @Setter
    private Fares fares;

    public Flight() { super(); }

    public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares) {
        super();
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.fares = fares;
    }

    public String toString() {
        return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", origin=" + origin + ", destination=" +
            destination + ", flightDate=" + flightDate + ", fares=" + fares + "]";
    }

}
