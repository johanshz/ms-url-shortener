package co.com.url_shortener.model.agreeement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Agreement {
    private final Integer id;
    private final Integer clientId;
    private final Integer contractorId;
}
