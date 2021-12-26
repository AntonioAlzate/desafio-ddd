package com.sofka.colciclapp.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.recorrido.values.RecorridoId;

public class IniciarRecorridoCommand extends Command {

    private final RecorridoId recorridoId;

    public IniciarRecorridoCommand(RecorridoId recorridoId){
        this.recorridoId = recorridoId;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }
}
