package lab.aikibo.etc;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by tamami on 27/06/17.
 */
public class SearchQuery {

    @Getter @Setter
    private String origin;
    @Getter @Setter
    private String destination;
    @Getter @Setter
    private String flightDate;

    public SearchQuery() { super(); }

    public SearchQuery(String origin, String destination, String flightDate) {
        super();
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
    }

    public String toString() {
        return "SearchQuery [origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + "]";
    }

}
