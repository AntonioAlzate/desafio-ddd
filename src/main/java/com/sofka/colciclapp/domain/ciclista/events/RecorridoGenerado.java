package com.sofka.colciclapp.domain.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;

public class RecorridoGenerado extends DomainEvent {


    private final RecorridoId recorridoId;
    private final RutaId rutaId;
    private final Direccion direccionOrigen;
    private final Direccion direccionDestino;
    private final Descripcion descripcion;
    private final Fecha fecha;

    public RecorridoGenerado(RecorridoId recorridoId, RutaId rutaId, Direccion direccionOrigen, Direccion direccionDestino, Descripcion descripcion, Fecha fecha) {
        super("sofka.ciclista.recorridogenerado");


        this.recorridoId = recorridoId;
        this.rutaId = rutaId;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
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
