package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.vigia.values.CalificacionId;
import com.sofka.colciclapp.vigia.values.Puntuacion;

public class PuntuacionDeCalificacionActualizada extends DomainEvent {
    private final CalificacionId entityId;
    private final Puntuacion puntuacion;

    public PuntuacionDeCalificacionActualizada(CalificacionId entityId, Puntuacion puntuacion) {
        super("sofka.vigia.puntuaciondecalificacionactualizada");
        this.entityId = entityId;
        this.puntuacion = puntuacion;
    }

    public CalificacionId getEntityId() {
        return entityId;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
