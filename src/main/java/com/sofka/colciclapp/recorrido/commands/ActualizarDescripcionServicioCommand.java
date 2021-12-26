package com.sofka.colciclapp.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.genericos.Descripcion;
import com.sofka.colciclapp.recorrido.values.RecorridoId;
import com.sofka.colciclapp.recorrido.values.ServicioId;

public class ActualizarDescripcionServicioCommand extends Command {

    private final RecorridoId recorridoId;
    private final ServicioId servicioId;
    private final Descripcion descripcion;

    public ActualizarDescripcionServicioCommand(RecorridoId recorridoId, ServicioId servicioId, Descripcion descripcion){

        this.recorridoId = recorridoId;
        this.servicioId = servicioId;
        this.descripcion = descripcion;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
