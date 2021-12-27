package com.sofka.colciclapp.domain.recorrido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Distancia implements ValueObject<Distancia.Properties> {

    private final Double valor;
    private final UnidadMedida unidadMedida;

    public Distancia(Double valor, UnidadMedida unidadMedida) {
        this.valor = Objects.requireNonNull(valor);
        if (this.valor <= 0) {
            throw new IllegalArgumentException("La distancia de un recorrido no puede ser negativo o igual a cero");
        }
        this.unidadMedida = Objects.requireNonNull(unidadMedida);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Double valor() {
                return valor;
            }

            @Override
            public UnidadMedida unidadMedida() {
                return unidadMedida;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distancia distancia = (Distancia) o;
        return Objects.equals(valor, distancia.valor) && Objects.equals(unidadMedida, distancia.unidadMedida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, unidadMedida);
    }

    public interface Properties {
        Double valor();

        UnidadMedida unidadMedida();
    }
}
