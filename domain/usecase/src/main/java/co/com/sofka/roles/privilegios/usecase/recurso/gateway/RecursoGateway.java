package co.com.sofka.roles.privilegios.usecase.recurso.gateway;

import co.com.sofka.roles.privilegios.model.Recurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoGateway {
    Mono<Recurso> crearRecurso(Recurso recurso);
    Flux<Recurso> listarRecursos();
    Mono<Recurso> buscarRecurso(Integer id);
    Mono<Void> eliminarRecurso(Integer id);

}
