package co.com.sofka.roles.privilegios.usecase.rol.gateway;

import co.com.sofka.roles.privilegios.model.UsuarioRol;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRolGateway {
    Mono<UsuarioRol> buscarUsuarioRol(String correo, Integer idRol);
    Mono<UsuarioRol> asignarRol(UsuarioRol usuarioRol);
    Mono<Void> eliminarUsuarioRol(UsuarioRol usuarioRol);
    Flux<UsuarioRol> buscarUsuarioRolPorCorreo(String correo);
}
