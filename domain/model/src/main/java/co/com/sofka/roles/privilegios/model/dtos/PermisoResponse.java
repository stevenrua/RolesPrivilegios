package co.com.sofka.roles.privilegios.model.dtos;

import co.com.sofka.roles.privilegios.model.Rol;

import java.util.List;

public class PermisoResponse {
    private Rol rol;
    //para el backend
    private List<RecursoEndpointsDto> recursos;
    //para el forntend
    //private List<Recurso> recursos;
}
