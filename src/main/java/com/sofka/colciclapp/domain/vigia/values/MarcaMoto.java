package com.sofka.colciclapp.domain.vigia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MarcaMoto implements ValueObject<String> {
    private final String value;

    public MarcaMoto(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La marca de una moto no puede ser vacia");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaMoto marcaMoto = (MarcaMoto) o;
        return Objects.equals(value, marcaMoto.value);
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
