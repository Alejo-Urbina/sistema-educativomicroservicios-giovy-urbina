package com.matriculas_servicio.servicio;

import com.matriculas_servicio.dto.MatriculaRespuesta;
import com.matriculas_servicio.dto.MatriculaSolicitud;
import com.matriculas_servicio.excepciones.MatriculaExcepcion;
import com.matriculas_servicio.externo.AsignaturaCliente;
import com.matriculas_servicio.externo.UsuarioCliente;
import com.matriculas_servicio.repositorio.interfaces.MatriculaRepositorio;
import com.matriculas_servicio.servicio.interfaces.MatriculaServicio;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServicioImpl implements MatriculaServicio {

    private final MatriculaRepositorio repositorio;
    private final UsuarioCliente usuarioCliente;
    private final AsignaturaCliente asignaturaCliente;

    public MatriculaServicioImpl(MatriculaRepositorio repositorio, UsuarioCliente usuarioCliente, AsignaturaCliente asignaturaCliente) {
        this.repositorio = repositorio;
        this.usuarioCliente = usuarioCliente;
        this.asignaturaCliente = asignaturaCliente;
    }

    @Override
    public MatriculaRespuesta asignarMatricula(MatriculaSolicitud matriculaSolicitud) {
        obtenerUsuario(matriculaSolicitud.getUsuarioId());
        obtenerAsignatura(matriculaSolicitud.getAsignaturaId());
        return repositorio.asignarMatricula(matriculaSolicitud);
    }

    public void obtenerUsuario(Integer usuarioId){
        try {
            usuarioCliente.obtenerUsuario(usuarioId);
        } catch (Exception e) {
            throw new MatriculaExcepcion("No se encuentra usuario con id: " + usuarioId);
        }
    }

    public void obtenerAsignatura(Integer asognaturaId){
        try {
            asignaturaCliente.obtenerAsignatura(asognaturaId);
        } catch (Exception e) {
            throw new MatriculaExcepcion("No se encuentra asignatura con id: " + asognaturaId);
        }
    }
}
