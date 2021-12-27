package com.sofka.colciclapp.domain.recorrido.values;

import co.com.sofka.domain.generic.Identity;

public class DetalleId extends Identity {

    public DetalleId() {

    }

    private DetalleId(String id) {
        super(id);
    }

    public static DetalleId of(String id) {
        return new DetalleId(id);
    }
}
