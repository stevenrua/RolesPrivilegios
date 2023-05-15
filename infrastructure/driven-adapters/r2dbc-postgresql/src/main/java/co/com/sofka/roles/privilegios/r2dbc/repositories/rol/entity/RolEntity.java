package co.com.sofka.roles.privilegios.r2dbc.repositories.rol.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("rol")
public class RolEntity {
    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
}
