package co.com.sofka.roles.privilegios.usecase.rol;

import co.com.sofka.roles.privilegios.model.UsuarioRol;
import co.com.sofka.roles.privilegios.model.dtos.UsuarioRolRequest;
import co.com.sofka.roles.privilegios.usecase.rol.gateway.UsuarioRolGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UsuarioRolUseCase {

    private final UsuarioRolGateway usuarioRolGateway;

    public Mono<UsuarioRol> asignarRol(UsuarioRol usuarioRol) {
        return usuarioRolGateway.asignarRol(usuarioRol);
    }

    public Mono<Void> cambiarRol(UsuarioRolRequest request) {
        return usuarioRolGateway.buscarUsuarioRol(request.getUsuarioRol().getCorreo(), request.getUsuarioRol().getIdRol())
                .flatMap(usuarioRol -> usuarioRolGateway.asignarRol(UsuarioRol.builder()
                                        .correo(usuarioRol.getCorreo())
                                        .idRol(request.getIdNuevoRol())
                                .build()))
                .flatMap(usuario -> usuarioRolGateway.eliminarUsuarioRol(UsuarioRol.builder()
                                .correo(usuario.getCorreo())
                                .idRol(request.getUsuarioRol().getIdRol())
                        .build()));
    }

    public Flux<UsuarioRol> buscarUsuarioRolPorCorreo(String correo){
        return usuarioRolGateway.buscarUsuarioRolPorCorreo(correo);
    }

}
