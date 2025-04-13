package com.matriculas_servicio.repositorio;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.repositorio.entidad.MatriculaEntidad;
import com.matriculas_servicio.repositorio.interfaces.MatriculaRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class MatriculaRepositorioImpl implements MatriculaRepositorio {

    private final String ESTADO_ACTIVA = "ACTIVA";

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public MatriculaRespuesta asignarMatricula(MatriculaSolicitud matriculaSolicitud) {
        MatriculaEntidad entidad = new MatriculaEntidad(matriculaSolicitud.getUsuarioId(),matriculaSolicitud.getAsignaturaId(),
                LocalDate.now(),ESTADO_ACTIVA);
        em.persist(entidad);
        return mapearRespuesta(entidad);
    }

    private final MatriculaRespuesta mapearRespuesta(MatriculaEntidad entidad){
        return new MatriculaRespuesta(entidad.getId(), entidad.getUsuarioId(), entidad.getAsignaturaId(),
                entidad.getFechaMatricula(), entidad.getEstado());
    }
}
