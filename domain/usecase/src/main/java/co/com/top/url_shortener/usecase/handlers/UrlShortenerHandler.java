package co.com.top.url_shortener.usecase.handlers;

import co.com.top.url_shortener.model.common.ex.ServiceException;

public interface UrlShortenerHandler {
    String handle(String urlShortener) throws ServiceException;
}
