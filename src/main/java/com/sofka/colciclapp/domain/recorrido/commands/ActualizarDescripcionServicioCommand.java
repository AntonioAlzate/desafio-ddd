package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.ServicioId;

public class ActualizarDescripcionServicioCommand extends Command {

    private final RecorridoId recorridoId;
    private final ServicioId servicioId;
    private final Descripcion descripcion;

    public ActualizarDescripcionServicioCommand(RecorridoId recorridoId, ServicioId servicioId, Descripcion descripcion) {

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
