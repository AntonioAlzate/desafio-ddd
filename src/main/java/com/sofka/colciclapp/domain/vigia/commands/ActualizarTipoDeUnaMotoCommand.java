package com.sofka.colciclapp.domain.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.vigia.values.MotoId;
import com.sofka.colciclapp.domain.vigia.values.TipoMoto;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class ActualizarTipoDeUnaMotoCommand extends Command {

    private final MotoId motoId;
    private final TipoMoto tipo;
    private final VigiaId vigiaId;

    public ActualizarTipoDeUnaMotoCommand(VigiaId vigiaId, MotoId motoId, TipoMoto tipo) {
        this.motoId = motoId;
        this.tipo = tipo;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public TipoMoto getTipo() {
        return tipo;
    }
}
