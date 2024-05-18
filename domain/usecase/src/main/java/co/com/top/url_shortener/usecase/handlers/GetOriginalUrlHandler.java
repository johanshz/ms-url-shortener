package co.com.top.url_shortener.usecase.handlers;

import co.com.top.url_shortener.model.common.ex.ServiceException;

import java.net.UnknownHostException;

public interface GetOriginalUrlHandler {
    String handle(String uniqueId) throws ServiceException, UnknownHostException;
}
