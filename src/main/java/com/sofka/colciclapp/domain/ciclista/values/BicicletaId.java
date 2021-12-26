package com.sofka.colciclapp.domain.ciclista.values;

import co.com.sofka.domain.generic.Identity;

public class BicicletaId extends Identity {

    public BicicletaId() {

    }

    private BicicletaId(String id) {
        super(id);
    }

    public static BicicletaId of(String id) {
        return new BicicletaId(id);
    }
}
