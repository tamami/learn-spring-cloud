package lab.aikibo.repo;

import lab.aikibo.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tamami on 28/06/17.
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);

}
