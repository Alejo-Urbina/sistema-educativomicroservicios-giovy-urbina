package com.matriculas_servicio.servicio.interfaces;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;

public interface MatriculaServicio {

    MatriculaRespuesta asignarMatricula(MatriculaSolicitud matriculaSolicitud);

}
