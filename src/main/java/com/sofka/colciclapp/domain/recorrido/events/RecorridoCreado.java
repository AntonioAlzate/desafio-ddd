package com.sofka.colciclapp.domain.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.genericos.Descripcion;
import com.sofka.colciclapp.domain.genericos.Fecha;
import com.sofka.colciclapp.domain.recorrido.Ruta;
import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RutaId;

public class RecorridoCreado extends DomainEvent {


    private final RutaId rutaId;
    private final Direccion direccionOrigen;
    private final Direccion direccionDestino;
    private final Descripcion descripcion;
    private final Fecha fecha;

    public RecorridoCreado(RutaId rutaId, Direccion direccionOrigen, Direccion direccionDestino, Descripcion descripcion, Fecha fecha) {
        super("sofka.recorrido.recorridocreado");

        this.rutaId = rutaId;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.descripcion = descripcion;
        this.fecha = fecha;
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
