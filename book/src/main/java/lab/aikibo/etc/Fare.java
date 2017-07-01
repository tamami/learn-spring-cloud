package lab.aikibo.etc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by tamami on 28/06/17.
 */
@ToString
public class Fare {

    @Setter @Getter
    private String flightNumber;
    @Setter @Getter
    private String flightDate;
    @Setter @Getter
    private String fare;

}
