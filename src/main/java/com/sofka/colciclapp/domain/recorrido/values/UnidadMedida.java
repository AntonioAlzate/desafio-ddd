package com.sofka.colciclapp.domain.recorrido.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.colciclapp.domain.recorrido.values.enums.Medida;

import java.util.Objects;

public class UnidadMedida implements ValueObject<Medida> {
    private final Medida value;

    public UnidadMedida(Medida value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadMedida that = (UnidadMedida) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Medida value() {
        return value;
    }
}
