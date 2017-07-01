package lab.aikibo.repo;

import lab.aikibo.entity.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tamami on 30/06/17.
 */
public interface CheckinRepository extends JpaRepository<CheckInRecord, Long> {
}
