package co.com.sofka.roles.privilegios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EndPoint {
    private Integer id;
    private Integer idMicroservicio;
    private String nombre;
    private String descripcion;
    private String uri;
}
