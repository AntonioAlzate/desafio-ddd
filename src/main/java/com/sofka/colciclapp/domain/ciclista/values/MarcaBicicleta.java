package com.sofka.colciclapp.domain.ciclista.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MarcaBicicleta implements ValueObject<String> {
    private final String value;

    public MarcaBicicleta(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La marca de una moto no puede ser vacia");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaBicicleta that = (MarcaBicicleta) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
