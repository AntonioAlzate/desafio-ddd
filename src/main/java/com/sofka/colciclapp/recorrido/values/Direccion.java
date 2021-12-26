package com.sofka.colciclapp.recorrido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<Direccion.Properties> {

    private final String direccion;
    private final Double latitud;
    private final Double longitud;

    public Direccion(String direccion, Double latitud, Double longitud) {
        this.direccion = Objects.requireNonNull(direccion);
        if(this.direccion.isBlank()){
            throw new IllegalArgumentException("La direccion no puede ser un valor vacio");
        }
        this.latitud = Objects.requireNonNull(latitud);
        this.longitud = Objects.requireNonNull(longitud);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public Double latitud() {
                return latitud;
            }

            @Override
            public Double longitud() {
                return longitud;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return Objects.equals(direccion, direccion1.direccion) && Objects.equals(latitud, direccion1.latitud) && Objects.equals(longitud, direccion1.longitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, latitud, longitud);
    }

    interface Properties{
        String direccion();
        Double latitud();
        Double longitud();
    }
}
