package co.com.top.url_shortener.controller.dto;

import co.com.top.url_shortener.model.agreeement.Agreement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
public class AgreementResponseDto {
    private Integer agreementId;
    private Integer clientId;
    private Integer contractorId;

    public static AgreementResponseDto fromDomain(Agreement agreement){
        return AgreementResponseDto.builder()
                .agreementId(agreement.getId())
                .clientId(agreement.getClientId())
                .contractorId(agreement.getContractorId())
                .build();
    }
}
