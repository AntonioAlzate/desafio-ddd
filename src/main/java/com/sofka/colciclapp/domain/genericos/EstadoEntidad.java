package com.sofka.colciclapp.domain.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoEntidad implements ValueObject<Estado> {
    private final Estado value;

    public EstadoEntidad(Estado value) {
        this.value = Objects.requireNonNull(value, "el estado es requerido");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoEntidad that = (EstadoEntidad) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Estado value() {
        return value;
    }
}
