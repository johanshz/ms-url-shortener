package co.com.top.url_shortener.model.traceability.gateway;

import co.com.top.url_shortener.model.traceability.Traceability;

import java.util.List;

public interface TraceabilityRepository {
    void save(Traceability traceability);
    List<Traceability> findAll();
}
