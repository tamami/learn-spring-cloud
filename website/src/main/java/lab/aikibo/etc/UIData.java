package lab.aikibo.etc;

import lab.aikibo.entity.Flight;
import lab.aikibo.entity.Passenger;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by tamami on 27/06/17.
 */
public class UIData {

    @Getter @Setter
    private SearchQuery searchQuery;
    @Getter @Setter
    private List<Flight> flights;
    @Getter @Setter
    private Flight selectedFlight;
    @Getter @Setter
    private Passenger passenger;
    @Getter @Setter
    private String bookingId;

}
