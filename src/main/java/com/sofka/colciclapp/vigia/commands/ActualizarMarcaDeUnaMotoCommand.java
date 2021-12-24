package com.sofka.colciclapp.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.vigia.values.MarcaMoto;
import com.sofka.colciclapp.vigia.values.MotoId;
import com.sofka.colciclapp.vigia.values.VigiaId;

public class ActualizarMarcaDeUnaMotoCommand extends Command {

    private final MotoId motoId;
    private final MarcaMoto marca;
    private final VigiaId vigiaId;

    public ActualizarMarcaDeUnaMotoCommand(VigiaId vigiaId, MotoId motoId, MarcaMoto marca) {

        this.motoId = motoId;
        this.marca = marca;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public MarcaMoto getMarca() {
        return marca;
    }
}
