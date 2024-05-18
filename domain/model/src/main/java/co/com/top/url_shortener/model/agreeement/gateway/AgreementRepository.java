package co.com.top.url_shortener.model.agreeement.gateway;

import co.com.top.url_shortener.model.agreeement.Agreement;

public interface AgreementRepository {
    Agreement getAgreementById(Integer agreementId);
}
