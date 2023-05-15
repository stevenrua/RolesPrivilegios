package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.model.Microservicio;
import co.com.sofka.roles.privilegios.usecase.microservicio.MicroservicioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/microservicio")
@RequiredArgsConstructor
public class MicroservicioController {

    private final MicroservicioUseCase microservicioUseCase;

    @GetMapping
    public Flux<Microservicio> listarMicroservicios() {
        return microservicioUseCase.listarMicroservicios();
    }

    @GetMapping("/{id}")
    public Mono<Microservicio> buscarMicroservicioPorId(@PathVariable("id") Integer id) {

        return microservicioUseCase.buscarMicroservicioPorId(id);
    }

    @PostMapping
    public Mono<Microservicio> guardarMicroservicio(@RequestBody Microservicio microservicio) {

        return microservicioUseCase.guardarMicroservicio(microservicio);
    }

    @PutMapping("/{id}")
    public Mono<Microservicio> editarMicroservicio(@PathVariable("id") Integer id, @RequestBody Microservicio microservicio) {

        return microservicioUseCase.editarMicroservicio(id, microservicio);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarMicroservicio(@PathVariable("id") Integer id) {

        return microservicioUseCase.eliminarMicroservicio(id);
    }
}
