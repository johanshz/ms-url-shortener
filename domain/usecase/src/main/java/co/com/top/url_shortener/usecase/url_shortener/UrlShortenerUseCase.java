package co.com.top.url_shortener.usecase.url_shortener;

import co.com.top.url_shortener.model.common.ex.ServiceException;
import co.com.top.url_shortener.model.url_shortener.UrlShortener;
import co.com.top.url_shortener.model.url_shortener.gateway.UrlShortenerRepository;
import co.com.top.url_shortener.usecase.handlers.UrlShortenerHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.security.SecureRandom;
import java.util.UUID;

@Log
@RequiredArgsConstructor
public class UrlShortenerUseCase implements UrlShortenerHandler {
    private static final SecureRandom RANDOM = new SecureRandom();
    private final UrlShortenerRepository urlShortenerRepository;
    @Override
    public String handle(String originalUrl) throws ServiceException {
        try{
            return urlShortenerRepository.save(buildUrlShortener(originalUrl,generateUniqueId()));
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }

    }
    private UrlShortener buildUrlShortener(String originalUrl,String uniqueId){
        return UrlShortener.builder()
                .originalUrl(originalUrl)
                .uniqueId(uniqueId)
                .build();
    }
    private  String generateUniqueId() {
        /*
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int ID_LENGTH = 6;
        StringBuilder id = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            id.append(CHARACTERS.charAt(index));
        }
        return id.toString();
        */

        return UUID.randomUUID().toString().replace("-","").substring(0,6);
    }
}
