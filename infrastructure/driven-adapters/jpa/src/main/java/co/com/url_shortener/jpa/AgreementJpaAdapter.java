package co.com.url_shortener.jpa;

import co.com.url_shortener.jpa.repositories.AgreementJpaRepository;
import co.com.url_shortener.model.agreeement.Agreement;
import co.com.url_shortener.model.agreeement.gateway.AgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgreementJpaAdapter implements AgreementRepository {
    private final AgreementJpaRepository agreementJpaRepository;

    @Override
    public Agreement getAgreementById(Integer agreementId) {
        return agreementJpaRepository.findById(agreementId)
                .map(agreementEntity -> Agreement.builder()
                        .id(agreementEntity.getId())
                        .build())
                .orElse(null);
    }
}
