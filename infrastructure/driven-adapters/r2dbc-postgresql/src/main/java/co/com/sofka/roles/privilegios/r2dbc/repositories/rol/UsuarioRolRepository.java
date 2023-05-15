package co.com.sofka.roles.privilegios.r2dbc.repositories.rol;

import co.com.sofka.roles.privilegios.r2dbc.repositories.rol.entity.UsuarioRolEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRolRepository extends R2dbcRepository<UsuarioRolEntity, String> {
    Mono<UsuarioRolEntity> findByCorreoAndIdRol(String correo, Integer idRol);
    Mono<Void> deleteByCorreoAndIdRol(String correo, Integer idRol);
    Flux<UsuarioRolEntity> findByCorreo(String correo);
}
