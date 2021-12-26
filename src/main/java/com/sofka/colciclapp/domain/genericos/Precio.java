package com.sofka.colciclapp.domain.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {
    private final Double valor;

    public Precio(Double valor) {
        this.valor = Objects.requireNonNull(valor);
        if (this.valor < 0) {
            throw new IllegalArgumentException("Un valor monetario no puede ser negativo");
        }
    }

    @Override
    public Double value() {
        return valor;
    }
}
