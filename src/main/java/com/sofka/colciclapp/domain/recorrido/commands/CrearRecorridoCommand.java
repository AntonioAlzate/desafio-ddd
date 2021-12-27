package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.Ruta;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;

public class CrearRecorridoCommand extends Command {


    private final RecorridoId entityId;
    private final RutaId rutaId;
    private final Direccion direccionOrigen;
    private final Direccion direccionDestino;
    private final Descripcion descripcion;
    private final Fecha fecha;

    public CrearRecorridoCommand(RecorridoId entityId, RutaId rutaId, Direccion direccionOrigen, Direccion direccionDestino, Descripcion descripcion, Fecha fecha) {


        this.entityId = entityId;
        this.rutaId = rutaId;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public RecorridoId getEntityId() {
        return entityId;
    }

    public RutaId getRutaId() {
        return rutaId;
    }

    public Direccion getDireccionOrigen() {
        return direccionOrigen;
    }

    public Direccion getDireccionDestino() {
        return direccionDestino;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
