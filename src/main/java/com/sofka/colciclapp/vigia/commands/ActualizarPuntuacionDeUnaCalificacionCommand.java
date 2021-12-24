package com.sofka.colciclapp.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.vigia.values.CalificacionId;
import com.sofka.colciclapp.vigia.values.Puntuacion;
import com.sofka.colciclapp.vigia.values.VigiaId;

public class ActualizarPuntuacionDeUnaCalificacionCommand extends Command {
    private final CalificacionId entityId;
    private final Puntuacion puntuacion;
    private final VigiaId vigiaId;

    public ActualizarPuntuacionDeUnaCalificacionCommand(VigiaId vigiaId, CalificacionId entityId, Puntuacion puntuacion) {
        this.entityId = entityId;
        this.puntuacion = puntuacion;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public CalificacionId getEntityId() {
        return entityId;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }
}
