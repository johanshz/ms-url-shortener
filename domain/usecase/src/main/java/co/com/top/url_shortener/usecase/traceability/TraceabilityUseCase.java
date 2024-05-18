package co.com.top.url_shortener.usecase.traceability;

import co.com.top.url_shortener.model.common.ex.ServiceException;
import co.com.top.url_shortener.model.traceability.Traceability;
import co.com.top.url_shortener.model.traceability.gateway.TraceabilityRepository;
import co.com.top.url_shortener.usecase.handlers.TraceabilityHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.List;


@Log
@RequiredArgsConstructor
public class TraceabilityUseCase implements TraceabilityHandler {
    private final TraceabilityRepository traceabilityRepository;
    @Override
    public List<Traceability> handle() throws ServiceException {
        try {
            List<Traceability> traceabilityList = traceabilityRepository.findAll();
            Collections.reverse(traceabilityList);
            return traceabilityList;
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
