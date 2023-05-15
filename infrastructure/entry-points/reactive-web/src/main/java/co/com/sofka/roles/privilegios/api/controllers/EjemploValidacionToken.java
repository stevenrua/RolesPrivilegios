package co.com.sofka.roles.privilegios.api.controllers;

import co.com.sofka.roles.privilegios.api.filter.RequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/validartoken")
@RequiredArgsConstructor
public class EjemploValidacionToken {

    @GetMapping
    public Mono<String> saludar(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        return RequestFilter.validarToken(token);
    }

}
