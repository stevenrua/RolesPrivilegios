package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.model.UsuarioRol;
import co.com.sofka.roles.privilegios.model.dtos.UsuarioRolRequest;
import co.com.sofka.roles.privilegios.usecase.rol.UsuarioRolUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/usuario-rol")
@RequiredArgsConstructor
public class UsuarioRolController {

    private final UsuarioRolUseCase useCase;

    @GetMapping("/{correo}")
    Flux<UsuarioRol> buscarUsuarioPorCorreo(@PathVariable("correo") String correo) {
        return useCase.buscarUsuarioRolPorCorreo(correo);
    }

    @PostMapping("/asignar")
    public Mono<UsuarioRol> asignarRol(@RequestBody UsuarioRol usuarioRol) {
        return useCase.asignarRol(usuarioRol);
    }

    @PostMapping("/cambiar")
    Mono<Void> cambiarRol(@RequestBody UsuarioRolRequest request) {
        return useCase.cambiarRol(request);
    }

}
