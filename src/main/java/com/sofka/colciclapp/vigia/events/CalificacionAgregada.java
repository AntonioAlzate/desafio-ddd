package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.vigia.values.CalificacionId;
import com.sofka.colciclapp.vigia.values.Puntuacion;

public class CalificacionAgregada extends DomainEvent {
    private final CalificacionId calificacionId;
    private final Puntuacion puntuacion;

    public CalificacionAgregada(CalificacionId calificacionId, Puntuacion puntuacion) {
        super("sofka.vigia.calificacionagregada");
        this.calificacionId = calificacionId;
        this.puntuacion = puntuacion;
    }

    public CalificacionId getCalificacionId() {
        return calificacionId;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
