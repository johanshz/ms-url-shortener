package co.com.top.url_shortener.usecase.handlers;

import co.com.top.url_shortener.model.agreeement.Agreement;
import co.com.top.url_shortener.model.common.ex.ServiceException;

public interface GetAgreementByIdHandler {
    Agreement handle(Integer agreementId) throws ServiceException;
}
