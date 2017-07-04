package lab.aikibo.component;

import lab.aikibo.entity.Fare;
import lab.aikibo.repo.FaresRepository;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tamami on 02/07/17.
 */
@Component
@NoArgsConstructor
public class FaresComponent {

    private static final Logger logger = LoggerFactory.getLogger(FaresComponent.class);

    private FaresRepository faresRepository;

    @Autowired
    public FaresComponent(FaresRepository faresRepository) {
        this.faresRepository = faresRepository;
    }

    public Fare getFare(String flightNumber, String flightDate) {
        logger.info("Looking for fares flightNumber " + flightNumber + " flightDate " + flightDate);
        return faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
    }

}
