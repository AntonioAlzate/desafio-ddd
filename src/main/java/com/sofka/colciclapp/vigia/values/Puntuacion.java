package com.sofka.colciclapp.vigia.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.colciclapp.ciclista.values.CiclistaId;

import java.util.Objects;

public class Puntuacion implements ValueObject<Puntuacion.Properties> {


    private final CiclistaId ciclistaId;
    private final String comentario;
    private final Puntaje puntuacion;

    public Puntuacion(CiclistaId ciclistaId, String comentario, Puntaje puntuacion) {
        this.ciclistaId = Objects.requireNonNull(ciclistaId, "El id ciclista es requerido");
        this.comentario = Objects.requireNonNull(comentario, "El comentario es requerido");
        if (this.comentario.isBlank()) {
            throw new IllegalArgumentException("Un comentario no puede estar en blanco");
        }
        if (this.comentario.length() <= 5) {
            throw new IllegalArgumentException("Un comentario no puede tener menos de 5 caracteres");
        }
        this.puntuacion = Objects.requireNonNull(puntuacion);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public CiclistaId ciclistaId() {
                return ciclistaId;
            }

            @Override
            public String comentario() {
                return comentario;
            }

            @Override
            public Puntaje puntuacion() {
                return puntuacion;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntuacion that = (Puntuacion) o;
        return Objects.equals(ciclistaId, that.ciclistaId) && Objects.equals(comentario, that.comentario) && puntuacion == that.puntuacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciclistaId, comentario, puntuacion);
    }

    interface Properties {
        CiclistaId ciclistaId();

        String comentario();

        Puntaje puntuacion();
    }
}
