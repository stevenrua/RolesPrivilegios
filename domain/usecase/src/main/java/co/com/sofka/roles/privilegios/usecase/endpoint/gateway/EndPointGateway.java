package co.com.sofka.roles.privilegios.usecase.endpoint.gateway;

import co.com.sofka.roles.privilegios.model.EndPoint;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EndPointGateway {
    Flux<EndPoint> listarEndPoints();
    Mono<EndPoint> buscarEndPointPorId(Integer id);
    Mono<EndPoint> guardarEndPoint(EndPoint endPoint);
    Mono<EndPoint> editarEndPoint(Integer id, EndPoint endPoint);
    Mono<Void> eliminarEndPoint(Integer id);
}
