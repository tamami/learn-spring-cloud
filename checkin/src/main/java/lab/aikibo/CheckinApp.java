package lab.aikibo;

import lab.aikibo.entity.CheckInRecord;
import lab.aikibo.repo.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class CheckinApp implements CommandLineRunner
{

    private static final Logger logger = LoggerFactory.getLogger(CheckinApp.class);

    @Autowired
    private CheckinRepository repository;

    public static void main( String[] args )
    {
        SpringApplication.run(CheckinApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        CheckInRecord record = new CheckInRecord("Franc", "Gean", "28A", new Date(), "BF101", "22-JAN-16", 1);

        CheckInRecord result = repository.save(record);
        logger.info("checked in successfully... " + result);

        logger.info("Looking to load checkIn record...");
        logger.info("Result : " + repository.findOne(result.getId()));
    }
}
