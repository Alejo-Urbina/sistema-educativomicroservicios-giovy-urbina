package com.matriculas_servicio.controlador;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.servicio.interfaces.MatriculaServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaControlador {

    private final MatriculaServicio servicio;

    public MatriculaControlador(MatriculaServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public MatriculaRespuesta crearUsuario(@RequestBody MatriculaSolicitud matriculaSolicitud){
        return servicio.asignarMatricula(matriculaSolicitud);
    }

}
