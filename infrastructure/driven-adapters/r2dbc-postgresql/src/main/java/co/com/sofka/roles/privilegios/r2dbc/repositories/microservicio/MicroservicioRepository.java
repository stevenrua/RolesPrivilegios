package co.com.sofka.roles.privilegios.r2dbc.repositories.microservicio;

import co.com.sofka.roles.privilegios.r2dbc.repositories.microservicio.entity.MicroservicioEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MicroservicioRepository extends ReactiveCrudRepository<MicroservicioEntity, Integer> {
}
