package co.com.sofka.roles.privilegios.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermisoRequest {

    private Integer idRol;
    private List<RecursoDto> recursos;

}
