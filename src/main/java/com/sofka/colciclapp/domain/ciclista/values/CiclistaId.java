package com.sofka.colciclapp.domain.ciclista.values;

import co.com.sofka.domain.generic.Identity;

public class CiclistaId extends Identity {

    public CiclistaId() {

    }

    private CiclistaId(String id) {
        super(id);
    }

    public static CiclistaId of(String id) {
        return new CiclistaId(id);
    }
}
