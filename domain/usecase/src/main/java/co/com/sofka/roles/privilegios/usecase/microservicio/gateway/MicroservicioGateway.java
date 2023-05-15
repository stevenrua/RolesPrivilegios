package co.com.sofka.roles.privilegios.usecase.microservicio.gateway;

import co.com.sofka.roles.privilegios.model.Microservicio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MicroservicioGateway {
    Flux<Microservicio> listarMicroservicios();
    Mono<Microservicio> buscarMicroservicioPorId(Integer id);
    Mono<Microservicio> guardarMicroservicio(Microservicio microservicio);
    Mono<Microservicio> editarMicroservicio(Integer id, Microservicio microservicio);
    Mono<Void> eliminarMicroservicio(Integer id);
}
