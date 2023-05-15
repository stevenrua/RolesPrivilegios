package co.com.sofka.roles.privilegios.usecase.permisos;

import co.com.sofka.roles.privilegios.model.RolRecurso;
import co.com.sofka.roles.privilegios.usecase.permisos.gateways.RolRecursoGateway;
import co.com.sofka.roles.privilegios.usecase.recurso.gateway.RecursoGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PermisoUseCase {
    private final RolRecursoGateway rolRecursoGateway;

    public Mono<RolRecurso> asignarRecursosRol(RolRecurso rolRecurso){
        return rolRecursoGateway.asignarRecursosRol(rolRecurso);
    }
}
