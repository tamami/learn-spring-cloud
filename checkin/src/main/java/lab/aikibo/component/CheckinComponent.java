package lab.aikibo.component;

import lab.aikibo.entity.CheckInRecord;
import lab.aikibo.repo.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by tamami on 30/06/17.
 */
@Component
public class CheckinComponent {

    private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

    private CheckinRepository checkinRepository;
    private Sender sender;

    @Autowired
    public CheckinComponent(CheckinRepository checkinRepository, Sender sender) {
        this.checkinRepository = checkinRepository;
        this.sender = sender;
    }

    public long checkIn(CheckInRecord checkIn) {
        checkIn.setCheckInTime(new Date());
        logger.info("Saving checkin");

        long id = checkinRepository.save(checkIn).getId();
        logger.info("Successfully saved checkin");

        logger.info("Sending booking id " + id);
        sender.send(id);
        return id;
    }

    public CheckInRecord getCheckInRecord(long id) {
        return checkinRepository.findOne(id);
    }

}
