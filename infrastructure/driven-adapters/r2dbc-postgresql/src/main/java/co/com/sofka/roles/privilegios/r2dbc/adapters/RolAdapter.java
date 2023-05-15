package co.com.sofka.roles.privilegios.r2dbc.adapters;

import co.com.sofka.roles.privilegios.model.Rol;
import co.com.sofka.roles.privilegios.r2dbc.mapper.Mapper;
import co.com.sofka.roles.privilegios.r2dbc.repositories.rol.RolRepository;
import co.com.sofka.roles.privilegios.r2dbc.repositories.rol.entity.RolEntity;
import co.com.sofka.roles.privilegios.usecase.rol.gateway.RolGateway;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RolAdapter implements RolGateway {

    private final RolRepository rolRepository;
    @Override
    public Flux<Rol> listarRoles() {
        return rolRepository.findAll()
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT, "Lista vacia")))
                .map(rolEntity -> Mapper.map(rolEntity, Rol.class));
    }

    @Override
    public Mono<Rol> buscarRolPorId(Integer id) {
        return rolRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(rolEntity -> Mapper.map(rolEntity, Rol.class));
    }

    @Override
    public Mono<Rol> guardarRol(Rol rol) {
        return rolRepository.save(Mapper.map(rol, RolEntity.class))
                .map(rolEntity -> Mapper.map(rolEntity, Rol.class));
    }

    @Override
    public Mono<Rol> editarRol(Integer id, Rol rol) {
        return rolRepository.findById(Integer.valueOf(id))
                .flatMap(rolEntity -> {
                    rolEntity.setNombre(rol.getNombre());
                    rolEntity.setDescripcion(rol.getDescripcion());
                    return rolRepository.save(rolEntity);
                })
                .map(rolEntity -> Mapper.map(rolEntity, Rol.class))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public Mono<Void> eliminarRol(Integer id) {
        return rolRepository.findById(Integer.valueOf(id))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(rolRepository::delete);
    }
}
