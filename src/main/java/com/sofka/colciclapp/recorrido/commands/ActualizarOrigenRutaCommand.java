package com.sofka.colciclapp.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.recorrido.values.Direccion;
import com.sofka.colciclapp.recorrido.values.RecorridoId;

public class ActualizarOrigenRutaCommand extends Command {

    private final RecorridoId recorridoId;
    private final Direccion direccionOrigen;

    public ActualizarOrigenRutaCommand(RecorridoId recorridoId, Direccion direccionOrigen){

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
