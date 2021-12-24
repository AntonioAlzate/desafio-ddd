package com.sofka.colciclapp.vigia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EspecialidadVigia implements ValueObject<Especialidad> {
    private final Especialidad value;

    public EspecialidadVigia(Especialidad value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspecialidadVigia that = (EspecialidadVigia) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Especialidad value() {
        return value;
    }
}
