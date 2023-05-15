package co.com.sofka.roles.privilegios.model.dtos;

import co.com.sofka.roles.privilegios.model.UsuarioRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolRequest {
    private UsuarioRol usuarioRol;
    private Integer idNuevoRol;
}
