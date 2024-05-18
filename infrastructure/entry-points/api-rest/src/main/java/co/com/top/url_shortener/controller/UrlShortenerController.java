package co.com.top.url_shortener.controller;


import co.com.top.url_shortener.controller.dto.TraceabilityResponseDto;
import co.com.top.url_shortener.controller.dto.UrlShortenerRequestDto;
import co.com.top.url_shortener.controller.dto.UrlShortenerResponseDto;
import co.com.top.url_shortener.model.common.ex.ServiceException;
import co.com.top.url_shortener.model.traceability.Traceability;
import co.com.top.url_shortener.usecase.handlers.GetOriginalUrlHandler;
import co.com.top.url_shortener.usecase.handlers.TraceabilityHandler;
import co.com.top.url_shortener.usecase.handlers.UrlShortenerHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UrlShortenerController {
    private final UrlShortenerHandler urlShortenerHandler;
    private final GetOriginalUrlHandler getOriginalUrlHandler;
    private final TraceabilityHandler traceabilityHandler;
    @PostMapping("/generarUrl")
    @ResponseBody
    @ApiOperation(value = "returns the url")
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = String.class, message = "OK"),
            @ApiResponse(code = 500, message = "Error getting the url")
    })
    public UrlShortenerResponseDto urlShortener(@RequestBody UrlShortenerRequestDto urlShortenerDto) throws ServiceException {
        return UrlShortenerResponseDto.fromDomain(urlShortenerHandler.handle(urlShortenerDto.getOriginalUrl()));
    }
    @GetMapping(path = "/{uniqueId}")
    @ApiOperation(value = "returns the url")
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = String.class, message = "OK"),
            @ApiResponse(code = 500, message = "Error getting the url")
    })
    public ResponseEntity<Void> getOriginalUrl(@PathVariable String uniqueId) throws ServiceException {
        try {
            String originalUrl = getOriginalUrlHandler.handle(uniqueId);
            if (originalUrl != null && !originalUrl.isEmpty()) {
                return ResponseEntity.status(HttpStatus.FOUND)
                        .header("Location", originalUrl)
                        .build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @GetMapping(path = "/traceability")
    @ApiOperation(value = "returns the url")
    @ApiResponses(value = {
            @ApiResponse(code = 200, response = String.class, message = "OK"),
            @ApiResponse(code = 500, message = "Error getting the url")
    })
    public List<TraceabilityResponseDto> getTraceability() throws ServiceException {
        try {
         return buildTraceabilityResponseList(traceabilityHandler.handle());
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
    private  List<TraceabilityResponseDto> buildTraceabilityResponseList(List<Traceability> traceabilityList) {
        return traceabilityList.stream()
                .map(traceability -> TraceabilityResponseDto.builder()
                        .ip(traceability.getIp())
                        .registrationDate(traceability.getRegistrationDate())
                        .uniqueId(traceability.getUniqueId())
                        .build())
                .collect(Collectors.toList());

    }

}
