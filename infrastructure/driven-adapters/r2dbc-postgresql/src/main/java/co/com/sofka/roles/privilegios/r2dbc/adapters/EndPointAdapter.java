package co.com.sofka.roles.privilegios.r2dbc.adapters;

import co.com.sofka.roles.privilegios.model.EndPoint;
import co.com.sofka.roles.privilegios.r2dbc.mapper.Mapper;
import co.com.sofka.roles.privilegios.r2dbc.repositories.endpoint.EndPointRepository;
import co.com.sofka.roles.privilegios.r2dbc.repositories.endpoint.entity.EndPointEntity;
import co.com.sofka.roles.privilegios.usecase.endpoint.gateway.EndPointGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EndPointAdapter implements EndPointGateway {

    private final EndPointRepository endPointRepository;
    @Override
    public Flux<EndPoint> listarEndPoints() {
        return endPointRepository.findAll()
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT)))
                .map(endPointEntity -> Mapper.map(endPointEntity, EndPoint.class));
    }

    @Override
    public Mono<EndPoint> buscarEndPointPorId(Integer id) {
        return endPointRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(endPointEntity -> Mapper.map(endPointEntity, EndPoint.class));
    }

    @Override
    public Mono<EndPoint> guardarEndPoint(EndPoint endPoint) {
        return endPointRepository.save(Mapper.map(endPoint, EndPointEntity.class))
                .map(endPointEntity -> Mapper.map(endPointEntity, EndPoint.class));
    }

    @Override
    public Mono<EndPoint> editarEndPoint(Integer id, EndPoint endPoint) {

        return endPointRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(endPointEntity -> {
                    endPointEntity.setIdMicroservicio(endPoint.getIdMicroservicio());
                    endPointEntity.setNombre(endPoint.getNombre());
                    endPointEntity.setDescripcion(endPoint.getDescripcion());
                    endPointEntity.setUri(endPoint.getUri());
                    return endPointRepository.save(endPointEntity);
                })
                .map(endPointEntity -> Mapper.map(endPointEntity, EndPoint.class));
    }

    @Override
    public Mono<Void> eliminarEndPoint(Integer id) {

        return endPointRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(endPointRepository::delete);
    }
}
