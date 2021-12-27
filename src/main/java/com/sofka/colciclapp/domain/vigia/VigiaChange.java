package com.sofka.colciclapp.domain.vigia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.genericos.Estado;
import com.sofka.colciclapp.domain.genericos.EstadoEntidad;
import com.sofka.colciclapp.domain.vigia.events.*;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;

import java.util.HashSet;
import java.util.Set;

public class VigiaChange extends EventChange {
    public VigiaChange(Vigia vigia) {


        apply((VigiaCreado event) -> {
            Set<Especialidad> especialidades = new HashSet<>();
            especialidades.add(event.getEspecialidad());
            Perfil perfil = new Perfil(event.getPerfilId(), event.getDescripcion(), especialidades);

            vigia.perfil = perfil;
            vigia.personaId = event.getPersonaId();
            vigia.motos = new HashSet<>();
            vigia.calificaciones = new HashSet<>();
            vigia.estado = new EstadoEntidad(Estado.ACTIVO);
        });

        apply((CalificacionAgregada event) -> {
            vigia.calificaciones.add(new Calificacion(
                    event.getCalificacionId(),
                    event.getPuntuacion()
            ));
        });

        apply((ColorDeMotoActualizada event) -> {
            Moto moto = vigia.obtenerMotoPorId(event.getMotoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la moto que desea actualizar"));

            moto.actualizarColor(new ColorVehiculo(event.getColor()));
        });

        apply((DescripcionPerfilActualizada event) -> {
            vigia.perfil.actualizarDescripcion(event.getDescripcion());
        });

        apply((EspecialidadAgregadaAlPerfil event) -> {
            if (vigia.perfil.especialidades().contains(event.getEspecialidad())) {
                throw new IllegalArgumentException("Una especialidad no se puede agregar 2 veces");
            }
            vigia.perfil.agregarEspecialidad(event.getEspecialidad());
        });

        apply((EspecialidadQuitadaDelPerfil event) -> {
            vigia.perfil.quitarEspecialidad(event.getEspecialidad());
        });

        apply((MarcaDeMotoActualizada event) -> {
            Moto moto = vigia.obtenerMotoPorId(event.getMotoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la moto que desea actualizar"));

            moto.actualizarMarca(event.getMarca());
        });

        apply((MotoAgregada event) -> {
            int numeroMotos = vigia.motos.size();

            if (numeroMotos == 5) {
                throw new IllegalArgumentException("No puedes agregar mas Motocicletas el maximo son 5");
            }

            vigia.motos.add(new Moto(
                    event.getEntityId(),
                    event.getTipo(),
                    event.getMarca(),
                    event.getColor()
            ));
        });

        apply((MotoQuitada event) -> {
            Moto moto = vigia.obtenerMotoPorId(event.getMotoId())
                    .orElseThrow(() -> new IllegalArgumentException("No es posible eliminar una moto que no existe"));

            vigia.motos.remove(moto);
        });

        apply((PuntuacionDeCalificacionActualizada event) -> {
            Calificacion calificacion = vigia.obtenerCalificacionPorId(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Esta calificación no existe"));

            calificacion.actualizarPuntuacion(event.getPuntuacion());
        });

        apply((TipoDeMotoActualizada event) -> {
            Moto moto = vigia.obtenerMotoPorId(event.getMotoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado la moto que desea actualizar"));

            moto.actualizarTipoMoto(event.getTipo());
        });

    }
}
