package co.com.sofka.roles.privilegios.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolRecurso {
    private Integer idRol;
    private Integer idRecurso;
    private Boolean estado;
}
