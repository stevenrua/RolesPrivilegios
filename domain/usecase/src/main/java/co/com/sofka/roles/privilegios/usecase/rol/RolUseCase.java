package co.com.sofka.roles.privilegios.usecase.rol;

import co.com.sofka.roles.privilegios.model.Rol;
import co.com.sofka.roles.privilegios.usecase.rol.gateway.RolGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RolUseCase {
    private final RolGateway rolGateway;

    public Flux<Rol> listarRoles(){
        return rolGateway.listarRoles();
    }
    public Mono<Rol> buscarRolPorId(Integer id){
        return rolGateway.buscarRolPorId(id);
    }
    public Mono<Rol> guardarRol(Rol rol){
        return rolGateway.guardarRol(rol);
    }
    public Mono<Rol> editarRol(Integer id, Rol rol){
        return rolGateway.editarRol(id, rol);
    }
    public Mono<Void> eliminarRol(Integer id){
        return rolGateway.eliminarRol(id);
    }
}
