package com.sofka.colciclapp.recorrido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Iniciado implements ValueObject<Boolean> {
    private final Boolean value;

    public Iniciado(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }
}
