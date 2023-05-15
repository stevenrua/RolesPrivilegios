package co.com.sofka.roles.privilegios.r2dbc.repositories.endpoint;

import co.com.sofka.roles.privilegios.r2dbc.repositories.endpoint.entity.EndPointEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EndPointRepository extends ReactiveCrudRepository<EndPointEntity, Integer> {
}
