package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public class ActualizarDestinoRutaCommand extends Command {

    private final RecorridoId recorridoId;
    private final Direccion direccionDestino;

    public ActualizarDestinoRutaCommand(RecorridoId recorridoId, Direccion direccionDestino) {

        this.recorridoId = recorridoId;
        this.direccionDestino = direccionDestino;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public Direccion getDireccionDestino() {
        return direccionDestino;
    }
}
