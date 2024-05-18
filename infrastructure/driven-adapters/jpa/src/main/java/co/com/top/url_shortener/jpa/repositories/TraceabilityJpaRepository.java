package co.com.top.url_shortener.jpa.repositories;

import co.com.top.url_shortener.jpa.model.TraceabilityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraceabilityJpaRepository extends CrudRepository<TraceabilityEntity,Integer> {
}
