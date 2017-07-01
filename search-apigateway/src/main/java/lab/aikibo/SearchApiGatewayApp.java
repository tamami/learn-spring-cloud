package lab.aikibo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;

/**
 * Hello world!
 *
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@CrossOrigin
@EnableSwagger2
public class SearchApiGatewayApp
{

    @Bean
    public CustomZuulFilter customerFilter() {
        return new CustomZuulFilter();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(SearchApiGatewayApp.class, args);
    }
}

@RestController
class SearchApiGatewayController {
    @RequestMapping("/")
    public String greet(HttpServletRequest req) {
        return "<h1>Search Gateway Powered by Zuul</h1>";
    }
}
