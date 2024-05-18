package co.com.url_shortener.model.agreeement.gateway;

import co.com.url_shortener.model.agreeement.Agreement;

public interface AgreementRepository {
    Agreement getAgreementById(Integer agreementId);
}
