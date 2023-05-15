package co.com.sofka.roles.privilegios.usecase.permisos.gateways;

import co.com.sofka.roles.privilegios.model.RolRecurso;
import reactor.core.publisher.Mono;

public interface RolRecursoGateway {
    Mono<RolRecurso> asignarRecursosRol(RolRecurso rolRecurso);
}
