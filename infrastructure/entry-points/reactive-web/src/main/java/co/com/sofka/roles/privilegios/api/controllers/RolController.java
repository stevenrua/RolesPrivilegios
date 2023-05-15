package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.model.Rol;
import co.com.sofka.roles.privilegios.usecase.rol.RolUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/rol")
@RequiredArgsConstructor
public class RolController {

    private final RolUseCase rolUseCase;
    @GetMapping
    public Flux<Rol> listarTodos() {
        return rolUseCase.listarRoles();
    }

    @GetMapping("/{id}")
    public Mono<Rol> buscarRolPorId(@PathVariable("id") Integer id) {

        return rolUseCase.buscarRolPorId(id);
    }

    @PostMapping
    public Mono<Rol> guardarRol(@RequestBody Rol rol){
        return rolUseCase.guardarRol(rol);
    }

    @PutMapping("/{id}")
    public Mono<Rol> editarRol(@PathVariable("id") Integer id, @RequestBody Rol rol){
        return rolUseCase.editarRol(id, rol);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarRol(@PathVariable("id") Integer id){
        return rolUseCase.eliminarRol(id);
    }
}
