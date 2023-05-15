package co.com.sofka.roles.privilegios.r2dbc.adapters;

import co.com.sofka.roles.privilegios.model.Recurso;
import co.com.sofka.roles.privilegios.r2dbc.mapper.Mapper;
import co.com.sofka.roles.privilegios.r2dbc.repositories.recursos.RecursoRepository;
import co.com.sofka.roles.privilegios.r2dbc.repositories.recursos.entity.RecursoEntity;
import co.com.sofka.roles.privilegios.usecase.recurso.gateway.RecursoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RecursoAdapter implements RecursoGateway {

    private final RecursoRepository repository;

    @Override
    public Mono<Recurso> crearRecurso(Recurso recurso) {
        return repository.save(Mapper.map(recurso, RecursoEntity.class))
                .map(recursoEntity -> Mapper.map(recursoEntity, Recurso.class));
    }

    @Override
    public Flux<Recurso> listarRecursos() {
        return repository.findAll()
                .map(entity -> Mapper.map(entity, Recurso.class));
    }

    @Override
    public Mono<Recurso> buscarRecurso(Integer id) {
        return repository.findById(id)
                .map(entity -> Mapper.map(entity, Recurso.class));
    }

    @Override
    public Mono<Void> eliminarRecurso(Integer id) {
        return repository.deleteById(id);
    }

}
