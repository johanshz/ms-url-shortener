package co.com.top.url_shortener.usecase.original_url;

import co.com.top.url_shortener.model.common.ex.ServiceException;
import co.com.top.url_shortener.model.traceability.Traceability;
import co.com.top.url_shortener.model.traceability.gateway.TraceabilityRepository;
import co.com.top.url_shortener.model.url_shortener.gateway.UrlShortenerRepository;
import co.com.top.url_shortener.usecase.handlers.GetOriginalUrlHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

@Log
@RequiredArgsConstructor
public class OriginalUrlUseCase implements GetOriginalUrlHandler {
    private final TraceabilityRepository traceabilityRepository;
    private final UrlShortenerRepository urlShortenerRepository;
    private final String URL = "https://api.ipify.org";
    @Override
    public String handle(String uniqueId) throws ServiceException {
        Traceability traceability = Traceability.builder()
                .ip(getIP())
                .uniqueId(uniqueId)
                .registrationDate(getDate())
                .build();
        traceabilityRepository.save(traceability);
        return urlShortenerRepository.originalUrl(uniqueId);
    }
    private String getDate(){
        LocalDate date = LocalDate.now();
        return date.toString();
    }
    private String getIP() throws ServiceException{
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(URL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
