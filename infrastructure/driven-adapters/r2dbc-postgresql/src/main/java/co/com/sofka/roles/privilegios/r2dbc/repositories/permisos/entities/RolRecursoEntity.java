package co.com.sofka.roles.privilegios.r2dbc.repositories.permisos.entities;

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
@Table("roles_recursos")
public class RolRecursoEntity {
    @Id
    private Integer idRol;
    private Integer idRecurso;
    private Boolean estado;
}
