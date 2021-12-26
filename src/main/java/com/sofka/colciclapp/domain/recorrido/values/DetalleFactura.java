package com.sofka.colciclapp.domain.recorrido.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.colciclapp.domain.genericos.Descripcion;

import java.util.Objects;

public class DetalleFactura implements ValueObject<DetalleFactura.Properties> {


    private final ServicioId servicioId;
    private final Descripcion descripcion;

    public DetalleFactura(ServicioId servicioId, Descripcion descripcion) {
        this.servicioId = Objects.requireNonNull(servicioId);
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public ServicioId servicioId() {
                return servicioId;
            }

            @Override
            public Descripcion descripcion() {
                return descripcion;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleFactura that = (DetalleFactura) o;
        return Objects.equals(servicioId, that.servicioId) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicioId, descripcion);
    }

    interface Properties {
        ServicioId servicioId();

        Descripcion descripcion();
    }
}
