package co.com.sofka.roles.privilegios.usecase.microservicio;

import co.com.sofka.roles.privilegios.model.Microservicio;
import co.com.sofka.roles.privilegios.usecase.microservicio.gateway.MicroservicioGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class MicroservicioUseCase {
    private final MicroservicioGateway microservicioGateway;

    public Flux<Microservicio> listarMicroservicios(){
        return microservicioGateway.listarMicroservicios();
    }
    public Mono<Microservicio> buscarMicroservicioPorId(Integer id){
        return microservicioGateway.buscarMicroservicioPorId(id);
    }
    public Mono<Microservicio> guardarMicroservicio(Microservicio microservicio){
        return microservicioGateway.guardarMicroservicio(microservicio);
    }
    public Mono<Microservicio> editarMicroservicio(Integer id, Microservicio microservicio){
        return microservicioGateway.editarMicroservicio(id, microservicio);
    }
    public Mono<Void> eliminarMicroservicio(Integer id) {
        return microservicioGateway.eliminarMicroservicio(id);
    }
}

