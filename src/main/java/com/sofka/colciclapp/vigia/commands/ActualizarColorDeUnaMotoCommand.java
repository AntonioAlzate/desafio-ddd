package com.sofka.colciclapp.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.genericos.Color;
import com.sofka.colciclapp.vigia.values.MotoId;
import com.sofka.colciclapp.vigia.values.VigiaId;

public class ActualizarColorDeUnaMotoCommand extends Command {

    private final MotoId motoId;
    private final Color color;
    private final VigiaId vigiaId;

    public ActualizarColorDeUnaMotoCommand(VigiaId vigiaId, MotoId motoId, Color color) {
        this.motoId = motoId;
        this.color = color;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public Color getColor() {
        return color;
    }
}
