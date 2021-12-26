package com.sofka.colciclapp.domain.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.vigia.values.Especialidad;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class AgregarEspecialidadAlPerfilCommand extends Command {

    private final Especialidad especialidad;
    private final VigiaId vigiaId;

    public AgregarEspecialidadAlPerfilCommand(VigiaId vigiaId, Especialidad especialidad) {
        this.especialidad = especialidad;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
