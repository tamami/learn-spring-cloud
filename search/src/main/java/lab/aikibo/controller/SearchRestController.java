package lab.aikibo.controller;

import lab.aikibo.component.SearchComponent;
import lab.aikibo.entity.Flight;
import lab.aikibo.etc.SearchQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by tamami on 28/06/17.
 */
@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchRestController {

    private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
    TPMCounter tpm = new TPMCounter();

    private SearchComponent searchComponent;

    @Value("${orginairports.shutdown")
    private String originAirportShutdownList;

    GaugeService gaugeService;

    @Autowired
    public SearchRestController(SearchComponent searchComponent, GaugeService gaugeService) {
        this.gaugeService = gaugeService;
        this.searchComponent = searchComponent;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query) {
        logger.info("Input : " + query);
        if(Arrays.asList(originAirportShutdownList.split(",")).contains(query.getOrigin())) {
            logger.info("The origin airport is in shutdown state");
            return new ArrayList<Flight>();
        }

        tpm.increment();
        gaugeService.submit("tpm", tpm.count.intValue());

        return searchComponent.search(query);
    }

}

class TPMCounter {
    LongAdder count;
    Calendar expiry = null;

    TPMCounter() { reset(); }

    void reset() {
        count = new LongAdder();
        expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, 1);
    }

    boolean isExpired() {
        return Calendar.getInstance().after(expiry);
    }

    void increment() {
        if(isExpired()) {
            reset();
        }

        count.increment();
    }
}
