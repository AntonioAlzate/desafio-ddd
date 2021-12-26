package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public class ActualizarOrigenRutaCommand extends Command {

    private final RecorridoId recorridoId;
    private final Direccion direccionOrigen;

    public ActualizarOrigenRutaCommand(RecorridoId recorridoId, Direccion direccionOrigen) {

        this.recorridoId = recorridoId;
        this.direccionOrigen = direccionOrigen;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public Direccion getDireccionOrigen() {
        return direccionOrigen;
    }
}
