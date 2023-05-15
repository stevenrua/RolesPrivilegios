package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.model.EndPoint;
import co.com.sofka.roles.privilegios.usecase.endpoint.EndPointUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/endpoint")
@RequiredArgsConstructor
public class EndPointController {

    private final EndPointUseCase endPointUseCase;
    @GetMapping
    public Flux<EndPoint> listarEndPoints() {

        return endPointUseCase.listarEndPoints();
    }

    @GetMapping("/{id}")
    public Mono<EndPoint> buscarEndPointPorId(@PathVariable("id") Integer id) {
        return endPointUseCase.buscarEndPointPorId(id);
    }

    @PostMapping
    public Mono<EndPoint> guardarEndPoint(@RequestBody EndPoint endPoint) {

        return endPointUseCase.guardarEndPoint(endPoint);
    }

    @PutMapping("/{id}")
    public Mono<EndPoint> editarEndPoint(@PathVariable("id") Integer id, @RequestBody EndPoint endPoint) {

        return endPointUseCase.editarEndPoint(id, endPoint);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarEndPoint(@PathVariable("id") Integer id) {

        return endPointUseCase.eliminarEndPoint(id);
    }
}
