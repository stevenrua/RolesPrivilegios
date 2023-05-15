package co.com.sofka.roles.privilegios.r2dbc.repositories.permisos;

import co.com.sofka.roles.privilegios.r2dbc.repositories.permisos.entities.RolRecursoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface RolRecursoRepository extends R2dbcRepository<RolRecursoEntity, Integer> {
}
