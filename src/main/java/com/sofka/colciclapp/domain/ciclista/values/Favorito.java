package com.sofka.colciclapp.domain.ciclista.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

import java.util.Objects;

public class Favorito implements ValueObject<RecorridoId> {

    private final RecorridoId recorridoId;

    public Favorito(RecorridoId recorridoId) {
        this.recorridoId = Objects.requireNonNull(recorridoId);
    }

    @Override
    public RecorridoId value() {
        return recorridoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorito favorito = (Favorito) o;
        return Objects.equals(recorridoId, favorito.recorridoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recorridoId);
    }
}
