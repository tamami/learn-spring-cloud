package lab.aikibo.etc;

import lombok.*;

/**
 * Created by tamami on 28/06/17.
 */
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class SearchQuery {

    @Getter @Setter @NonNull
    private String origin;
    @Getter @Setter @NonNull
    private String destination;
    @Getter @Setter @NonNull
    private String flightDate;

}
