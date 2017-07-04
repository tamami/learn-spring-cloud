package lab.aikibo.controller;

import lab.aikibo.component.FaresComponent;
import lab.aikibo.entity.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tamami on 02/07/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresController {

    FaresComponent faresComponent;

    @Autowired
    public FaresController(FaresComponent faresComponent) {
        this.faresComponent = faresComponent;
    }

    @RequestMapping("/get")
    Fare getFare(@RequestParam(value="flightNumber") String flightNumber,
                 @RequestParam(value="flightDate") String flightDate) {
        return faresComponent.getFare(flightNumber, flightDate);
    }

}
