package com.sofka.colciclapp.vigia.values;

import co.com.sofka.domain.generic.Identity;

public class VigiaId extends Identity {

    public VigiaId() {

    }

    private VigiaId(String id) {
        super(id);
    }

    public static VigiaId of(String id) {
        return new VigiaId(id);
    }
}
