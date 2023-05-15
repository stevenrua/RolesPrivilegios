package co.com.sofka.roles.privilegios.r2dbc.repositories.recursos;

import co.com.sofka.roles.privilegios.r2dbc.repositories.recursos.entity.RecursoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RecursoRepository extends ReactiveCrudRepository<RecursoEntity, Integer> {
}
