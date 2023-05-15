package co.com.sofka.roles.privilegios.r2dbc.repositories.rol.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("usuario_rol")
public class UsuarioRolEntity {
    @Id
    private String correo;
    private Integer idRol;
}
