package com.sofka.colciclapp.domain.vigia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoMoto implements ValueObject<Proposito> {
    private final Proposito value;

    public TipoMoto(Proposito value) {
        this.value = Objects.requireNonNull(value, "el proposito es requerido");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoMoto tipoMoto = (TipoMoto) o;
        return value == tipoMoto.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Proposito value() {
        return value;
    }
}
