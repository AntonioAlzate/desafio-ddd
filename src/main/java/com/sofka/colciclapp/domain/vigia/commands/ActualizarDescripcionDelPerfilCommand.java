package com.sofka.colciclapp.domain.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class ActualizarDescripcionDelPerfilCommand extends Command {

    private final Descripcion descripcion;
    private final VigiaId vigiaId;

    public ActualizarDescripcionDelPerfilCommand(VigiaId vigiaId, Descripcion descripcion) {
        this.descripcion = descripcion;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
