package co.com.sofka.roles.privilegios.r2dbc.repositories.endpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("endpoint")
public class EndPointEntity {
    @Id
    private Integer id;
    @Column("idmicroservicio")
    private Integer idMicroservicio;
    private String nombre;
    private String descripcion;
    private String uri;
}
