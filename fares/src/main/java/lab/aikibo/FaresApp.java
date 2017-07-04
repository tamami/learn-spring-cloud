package lab.aikibo;

import lab.aikibo.entity.Fare;
import lab.aikibo.repo.FaresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class FaresApp implements CommandLineRunner
{

    private static final Logger logger = LoggerFactory.getLogger(FaresApp.class);

    @Autowired
    FaresRepository faresRepository;

    public static void main( String[] args )
    {
        SpringApplication.run(FaresApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Fare[] fares = {
            new Fare("BF100", "22-JAN-16", "100"),
            new Fare("BF101", "22-JAN-16", "101"),
            new Fare("BF102", "22-JAN-16", "102"),
            new Fare("BF103", "22-JAN-16", "103"),
            new Fare("BF104", "22-JAN-16", "104"),
            new Fare("BF105", "22-JAN-16", "105"),
            new Fare("BF106", "22-JAN-16", "106")
        };

        List<Fare> list = Arrays.stream(fares).collect(Collectors.toList());
        list.forEach(fare -> faresRepository.save(fare));

        logger.info("Result: " + faresRepository.getFareByFlightNumberAndFlightDate("BF101", "22-JAN-16"));
    }
}
