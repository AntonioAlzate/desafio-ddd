package com.sofka.colciclapp.recorrido;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.genericos.Descripcion;
import com.sofka.colciclapp.recorrido.values.Direccion;
import com.sofka.colciclapp.recorrido.values.Distancia;
import com.sofka.colciclapp.recorrido.values.RutaId;

import java.util.Objects;

public class Ruta extends Entity<RutaId> {

    private Direccion direccionOrigen;
    private Direccion direccionDestino;
    private Distancia distancia;
    private Descripcion descripcion;

    public Ruta(RutaId entityId, Direccion direccionOrigen, Direccion direccionDestino, Descripcion descripcion) {
        super(entityId);
        this.direccionOrigen = Objects.requireNonNull(direccionOrigen, "La dirección de origen es requerida");
        this.direccionDestino = Objects.requireNonNull(direccionDestino, "La dirección de destino es requerida");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción es requerida");
    }

    public void actualizarDireccionOrigen(Direccion direccionOrigen){
        this.direccionOrigen = Objects.requireNonNull(direccionOrigen);
    }

    public void actualizarDireccionDestino(Direccion direccionDestino){
        this.direccionDestino = Objects.requireNonNull(direccionDestino);
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Direccion direccionOrigen() {
        return direccionOrigen;
    }

    public Direccion direccionDestino() {
        return direccionDestino;
    }

    public Distancia distancia() {
        return distancia;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
