package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class AsociarVigiaCommand extends Command {

    private final RecorridoId recorridoId;
    private final VigiaId vigiaId;

    public AsociarVigiaCommand(RecorridoId recorridoId, VigiaId vigiaId) {

        this.recorridoId = recorridoId;
        this.vigiaId = vigiaId;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }
}
