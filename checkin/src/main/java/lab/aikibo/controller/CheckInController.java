package lab.aikibo.controller;

import lab.aikibo.component.CheckinComponent;
import lab.aikibo.entity.CheckInRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tamami on 30/06/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

    private CheckinComponent checkinComponent;

    @Autowired
    public CheckInController(CheckinComponent checkinComponent) {
        this.checkinComponent = checkinComponent;
    }

    @RequestMapping("/get/{id}")
    public CheckInRecord getCheckIn(@PathVariable long id) {
        return checkinComponent.getCheckInRecord(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public long checkIn(@RequestBody CheckInRecord checkIn) {
        return checkinComponent.checkIn(checkIn);
    }

}
