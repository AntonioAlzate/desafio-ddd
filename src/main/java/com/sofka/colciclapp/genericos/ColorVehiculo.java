package com.sofka.colciclapp.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ColorVehiculo implements ValueObject<Color> {

    private final Color color;

    public ColorVehiculo(Color color){
        this.color = Objects.requireNonNull(color, "El color es requerido");
    }

    @Override
    public Color value() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorVehiculo that = (ColorVehiculo) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
