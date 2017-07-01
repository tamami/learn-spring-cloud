package lab.aikibo.repo;

import lab.aikibo.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tamami on 28/06/17.
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, String flightDate);
    Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);

}
