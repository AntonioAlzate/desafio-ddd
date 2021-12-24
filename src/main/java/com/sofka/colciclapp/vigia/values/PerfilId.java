package com.sofka.colciclapp.vigia.values;

import co.com.sofka.domain.generic.Identity;

public class PerfilId extends Identity {

    public PerfilId() {

    }

    private PerfilId(String id) {
        super(id);
    }

    public static PerfilId of(String id) {
        return new PerfilId(id);
    }
}
