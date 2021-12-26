package com.sofka.colciclapp.domain.vigia;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.vigia.values.CalificacionId;
import com.sofka.colciclapp.domain.vigia.values.Puntuacion;

import java.util.Objects;

public class Calificacion extends Entity<CalificacionId> {

    private Puntuacion puntuacion;

    public Calificacion(CalificacionId entityId, Puntuacion puntuacion) {
        super(entityId);
        this.puntuacion = puntuacion;
    }

    public void actualizarPuntuacion(Puntuacion puntuacion) {
        this.puntuacion = Objects.requireNonNull(puntuacion);
    }

    public Puntuacion puntuacion() {
        return puntuacion;
    }
}
