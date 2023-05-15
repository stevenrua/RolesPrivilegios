package co.com.sofka.roles.privilegios.r2dbc.adapters;

import co.com.sofka.roles.privilegios.model.UsuarioRol;
import co.com.sofka.roles.privilegios.r2dbc.mapper.Mapper;
import co.com.sofka.roles.privilegios.r2dbc.repositories.rol.UsuarioRolRepository;
import co.com.sofka.roles.privilegios.r2dbc.repositories.rol.entity.UsuarioRolEntity;
import co.com.sofka.roles.privilegios.usecase.rol.gateway.UsuarioRolGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioRolAdapter implements UsuarioRolGateway {

    private final UsuarioRolRepository repository;


    @Override
    public Mono<UsuarioRol> buscarUsuarioRol(String correo, Integer idRol) {
        return repository.findByCorreoAndIdRol(correo, idRol)
                .map(entity -> Mapper.map(entity, UsuarioRol.class));
    }

    @Override
    public Mono<UsuarioRol> asignarRol(UsuarioRol usuarioRol) {
        return repository.save(Mapper.map(usuarioRol, UsuarioRolEntity.class))
                .map(usuarioRolEntity -> Mapper.map(usuarioRolEntity, UsuarioRol.class));
    }

    @Override
    public Mono<Void> eliminarUsuarioRol(UsuarioRol usuarioRol) {
        return repository.deleteByCorreoAndIdRol(usuarioRol.getCorreo(), usuarioRol.getIdRol());
    }

    @Override
    public Flux<UsuarioRol> buscarUsuarioRolPorCorreo(String correo) {
        return repository.findByCorreo(correo)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(usuarioRolEntity -> Mapper.map(usuarioRolEntity, UsuarioRol.class));
    }

}
