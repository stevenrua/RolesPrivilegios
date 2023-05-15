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
@Table("recursos_endpoints")
public class RecursoEndpointEntity {
    @Id
    private Integer idRol;
    private Integer idRecurso;
    private Integer idEndpoint;
    private Boolean estado;
}
