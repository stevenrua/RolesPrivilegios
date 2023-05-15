package co.com.sofka.roles.privilegios.usecase.recurso;

import co.com.sofka.roles.privilegios.model.Recurso;
import co.com.sofka.roles.privilegios.usecase.recurso.gateway.RecursoGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RecursoUseCase {

    private final RecursoGateway gateway;

    public Mono<Recurso> crearRecurso(Recurso recurso) {
        return gateway.crearRecurso(recurso);
    }

    public Flux<Recurso> listarRecursos() {
        return gateway.listarRecursos();
    }

    public Mono<Recurso> buscarRecurso(Integer id) {
        return gateway.buscarRecurso(id);
    }

    public Mono<Void> eliminarRecurso(Integer id) {
        return gateway.eliminarRecurso(id);
    }

}
