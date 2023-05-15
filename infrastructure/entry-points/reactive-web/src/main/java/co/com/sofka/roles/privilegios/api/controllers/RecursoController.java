package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.model.Recurso;
import co.com.sofka.roles.privilegios.usecase.recurso.RecursoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/recursos")
@RequiredArgsConstructor
public class RecursoController {

    private final RecursoUseCase useCase;

    @PostMapping("/guardar")
    public Mono<Recurso> crearRecurso(@RequestBody Recurso recurso) {
        return useCase.crearRecurso(recurso);
    }

    @GetMapping("/lista")
    public Flux<Recurso> listarRecursos() {
        return useCase.listarRecursos();
    }

    @GetMapping("/{id}")
    public Mono<Recurso> buscarRecurso(@PathVariable("id") Integer id) {
        return useCase.buscarRecurso(id);
    }

    @PutMapping("/actualizar")
    public Mono<Recurso> actualizarRecurso(@RequestBody Recurso recurso) {
        return useCase.crearRecurso(recurso);
    }

    @DeleteMapping("/eliminar/{id}")
    public Mono<Void> eliminarRecurso(@PathVariable("id") Integer id) {
        return useCase.eliminarRecurso(id);
    }

}
