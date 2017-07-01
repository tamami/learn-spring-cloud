package lab.aikibo.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by tamami on 28/06/17.
 */
@Component
public class Sender {

    RabbitMessagingTemplate template;

    @Autowired
    public Sender(RabbitMessagingTemplate template) {
        this.template = template;
    }

    @Bean
    public Queue queueSearch() {
        return new Queue("searchQ", false);
    }

    @Bean
    public Queue queueCheckIn() {
        return new Queue("checkInQ", false);
    }

    @Bean
    public Queue queueInventory() {
        return new Queue("inventoryQ", false);
    }

    public void sendSearch(Object message) {
        template.convertAndSend("searchQ", message);
    }

    public void sendCheckIn(Object message) {
        template.convertAndSend("checkInQ", message);
    }

    public void sendInventory(Object message) {
        template.convertAndSend("inventoryQ", message);
    }

}
