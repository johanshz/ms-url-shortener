package co.com.url_shortener.usecase.handlers;

import co.com.url_shortener.model.agreeement.Agreement;
import co.com.url_shortener.model.common.ex.ServiceException;

public interface GetAgreementByIdHandler {
    Agreement handle(Integer agreementId) throws ServiceException;
}
