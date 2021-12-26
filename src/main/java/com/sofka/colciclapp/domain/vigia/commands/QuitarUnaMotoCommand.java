package com.sofka.colciclapp.domain.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.vigia.values.MotoId;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class QuitarUnaMotoCommand extends Command {

    private final MotoId motoId;
    private final VigiaId vigiaId;

    public QuitarUnaMotoCommand(VigiaId vigiaId, MotoId motoId) {
        this.vigiaId = vigiaId;
        this.motoId = motoId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public MotoId getMotoId() {
        return motoId;
    }
}