package com.sofka.colciclapp.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.genericos.Descripcion;
import com.sofka.colciclapp.recorrido.values.RecorridoId;

public class ActualizarDescripcionRutaCommand extends Command {

    private final RecorridoId recorridoId;
    private final Descripcion descripcion;

    public ActualizarDescripcionRutaCommand(RecorridoId recorridoId, Descripcion descripcion){

        this.recorridoId = recorridoId;
        this.descripcion = descripcion;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
