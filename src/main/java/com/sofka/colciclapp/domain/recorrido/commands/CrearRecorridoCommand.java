package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.Ruta;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public class CrearRecorridoCommand extends Command {

    private final RecorridoId entityId;
    private final Ruta ruta;
    private final Fecha fecha;

    public CrearRecorridoCommand(RecorridoId entityId, Ruta ruta, Fecha fecha) {

        this.entityId = entityId;
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public RecorridoId getEntityId() {
        return entityId;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
