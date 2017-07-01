package lab.aikibo.component;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by tamami on 28/06/17.
 */
@Component
@EnableBinding(SearchSink.class)
@NoArgsConstructor
public class Receiver {

    @Autowired
    private SearchComponent searchComponent;

    @ServiceActivator(inputChannel = SearchSink.INVENTORYQ)
    public void accept(Map<String, Object> fare) {
        searchComponent.updateInventory((String) fare.get("FLIGHT_NUMBER"), (String) fare.get("FLIGHT_DATE"),
            (int) fare.get("NEW_INVENTORY"));
    }

}

interface SearchSink {
    public static String INVENTORYQ = "inventoryQ";

    @Input("inventoryQ")
    public MessageChannel inventoryQ();
}
