package co.com.sofka.roles.privilegios.r2dbc.adapters;

import co.com.sofka.roles.privilegios.model.Microservicio;
import co.com.sofka.roles.privilegios.r2dbc.mapper.Mapper;
import co.com.sofka.roles.privilegios.r2dbc.repositories.microservicio.MicroservicioRepository;
import co.com.sofka.roles.privilegios.r2dbc.repositories.microservicio.entity.MicroservicioEntity;
import co.com.sofka.roles.privilegios.usecase.microservicio.gateway.MicroservicioGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MicroservicioAdapter implements MicroservicioGateway {

    private final MicroservicioRepository microservicioRepository;
    @Override
    public Flux<Microservicio> listarMicroservicios() {
        return microservicioRepository.findAll()
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT, "Lista vacia")))
                .map(microservicioEntity -> Mapper.map(microservicioEntity, Microservicio.class));
    }

    @Override
    public Mono<Microservicio> buscarMicroservicioPorId(Integer id) {
        return microservicioRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(microservicioEntity -> Mapper.map(microservicioEntity, Microservicio.class));
    }

    @Override
    public Mono<Microservicio> guardarMicroservicio(Microservicio microservicio) {
        return microservicioRepository.save(Mapper.map(microservicio, MicroservicioEntity.class))
                .map(microservicioEntity -> Mapper.map(microservicioEntity, Microservicio.class));
    }

    @Override
    public Mono<Microservicio> editarMicroservicio(Integer id, Microservicio microservicio) {
        return microservicioRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(microservicioEntity -> {
                    microservicioEntity.setNombre(microservicio.getNombre());
                    microservicioEntity.setDescripcion(microservicio.getDescripcion());
                    return microservicioRepository.save(microservicioEntity);
                })
                .map(microservicioEntity -> Mapper.map(microservicioEntity, Microservicio.class));
    }

    @Override
    public Mono<Void> eliminarMicroservicio(Integer id) {
        return microservicioRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(microservicioRepository::delete);
    }
}
