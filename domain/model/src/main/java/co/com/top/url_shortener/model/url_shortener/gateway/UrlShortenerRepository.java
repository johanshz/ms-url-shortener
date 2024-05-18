package co.com.top.url_shortener.model.url_shortener.gateway;

import co.com.top.url_shortener.model.url_shortener.UrlShortener;

public interface UrlShortenerRepository {
    String save(UrlShortener urlShortener);
    String originalUrl(String uniqueId);
}
