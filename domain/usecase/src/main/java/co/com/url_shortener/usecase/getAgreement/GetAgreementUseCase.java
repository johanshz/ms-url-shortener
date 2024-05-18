package co.com.url_shortener.usecase.getAgreement;

import co.com.url_shortener.model.agreeement.Agreement;
import co.com.url_shortener.model.agreeement.gateway.AgreementRepository;
import co.com.url_shortener.model.common.ex.ServiceException;
import co.com.url_shortener.usecase.handlers.GetAgreementByIdHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class GetAgreementUseCase implements GetAgreementByIdHandler {

    private final AgreementRepository agreementRepository;

    @Override
    public Agreement handle(Integer agreementId) throws ServiceException {
        return agreementRepository.getAgreementById(agreementId);
    }
}
