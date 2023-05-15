package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.model.RolRecurso;
import co.com.sofka.roles.privilegios.model.UsuarioRol;
import co.com.sofka.roles.privilegios.usecase.permisos.PermisoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/rol-recurso")
@RequiredArgsConstructor
public class RolRecursoController {
    private final PermisoUseCase permisoUseCase;

    @PostMapping
    public Mono<RolRecurso> asignarRecursoRol(@RequestBody RolRecurso rolRecurso) {
        return permisoUseCase.asignarRecursosRol(rolRecurso);
    }
}
