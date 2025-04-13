package com.matriculas_servicio.repositorio.interfaces;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;

public interface MatriculaRepositorio {

    MatriculaRespuesta asignarMatricula(MatriculaSolicitud matriculaSolicitud);


}
