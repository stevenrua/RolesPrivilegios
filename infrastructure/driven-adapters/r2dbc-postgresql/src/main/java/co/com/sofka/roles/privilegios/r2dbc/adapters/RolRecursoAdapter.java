package co.com.sofka.roles.privilegios.r2dbc.adapters;

import co.com.sofka.roles.privilegios.model.RolRecurso;
import co.com.sofka.roles.privilegios.r2dbc.mapper.Mapper;
import co.com.sofka.roles.privilegios.r2dbc.repositories.permisos.RolRecursoRepository;
import co.com.sofka.roles.privilegios.r2dbc.repositories.permisos.entities.RolRecursoEntity;
import co.com.sofka.roles.privilegios.usecase.permisos.gateways.RolRecursoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RolRecursoAdapter implements RolRecursoGateway {

    private final RolRecursoRepository rolRecursoRepository;
    @Override
    public Mono<RolRecurso> asignarRecursosRol(RolRecurso rolRecurso) {
        return rolRecursoRepository.save(Mapper.map(rolRecurso, RolRecursoEntity.class))
                .map(rolRecursoEntity -> Mapper.map(rolRecursoEntity, RolRecurso.class));
    }
}
