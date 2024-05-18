package co.com.top.url_shortener.usecase.handlers;

import co.com.top.url_shortener.model.common.ex.ServiceException;
import co.com.top.url_shortener.model.traceability.Traceability;

import java.util.List;

public interface TraceabilityHandler {
    List<Traceability> handle() throws ServiceException;
}
