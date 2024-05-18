package co.com.url_shortener.controller;

import co.com.url_shortener.usecase.handlers.GetAgreementByIdHandler;
import co.com.url_shortener.usecase.handlers.UrlShortenerHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TestController {
    private final GetAgreementByIdHandler getAgreementByIdHandler;
    private final UrlShortenerHandler urlShortenerHandler;






}
