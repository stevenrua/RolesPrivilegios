package co.com.sofka.roles.privilegios.r2dbc.repositories.rol;

import co.com.sofka.roles.privilegios.r2dbc.repositories.rol.entity.RolEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RolRepository extends ReactiveCrudRepository<RolEntity, Integer> {
}
