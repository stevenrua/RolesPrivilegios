package co.com.sofka.roles.privilegios.usecase.rol.gateway;

import co.com.sofka.roles.privilegios.model.Rol;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolGateway {
    Flux<Rol> listarRoles();
    Mono<Rol> buscarRolPorId(Integer id);
    Mono<Rol> guardarRol(Rol rol);
    Mono<Rol> editarRol(Integer id, Rol rol);

    Mono<Void> eliminarRol(Integer id);
}
