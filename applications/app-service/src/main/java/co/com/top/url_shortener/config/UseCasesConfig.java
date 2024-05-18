package co.com.top.url_shortener.config;

import co.com.top.url_shortener.model.agreeement.gateway.AgreementRepository;
import co.com.top.url_shortener.usecase.getAgreement.GetAgreementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.top.url_shortener.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
    @Bean
    public GetAgreementUseCase getAgreementUseCase(
            AgreementRepository agreementRepository
    ) {
        return new GetAgreementUseCase(agreementRepository);
    }
}
