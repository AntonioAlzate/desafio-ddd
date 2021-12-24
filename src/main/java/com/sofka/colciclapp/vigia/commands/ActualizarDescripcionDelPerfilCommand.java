package com.sofka.colciclapp.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.genericos.Descripcion;
import com.sofka.colciclapp.vigia.values.VigiaId;

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
