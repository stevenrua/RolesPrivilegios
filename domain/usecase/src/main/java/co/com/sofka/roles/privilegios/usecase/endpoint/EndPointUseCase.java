package co.com.sofka.roles.privilegios.usecase.endpoint;

import co.com.sofka.roles.privilegios.model.EndPoint;
import co.com.sofka.roles.privilegios.model.Microservicio;
import co.com.sofka.roles.privilegios.usecase.endpoint.gateway.EndPointGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EndPointUseCase {
    private final EndPointGateway endPointGateway;

    public Flux<EndPoint> listarEndPoints(){
        return endPointGateway.listarEndPoints();
    }
    public Mono<EndPoint> buscarEndPointPorId(Integer id){
        return endPointGateway.buscarEndPointPorId(id);
    }
    public Mono<EndPoint> guardarEndPoint(EndPoint endPoint){
        return endPointGateway.guardarEndPoint(endPoint);
    }
    public Mono<EndPoint> editarEndPoint(Integer id, EndPoint endPoint){
        return endPointGateway.editarEndPoint(id, endPoint);
    }
    public Mono<Void> eliminarEndPoint(Integer id) {
        return endPointGateway.eliminarEndPoint(id);
    }
}
