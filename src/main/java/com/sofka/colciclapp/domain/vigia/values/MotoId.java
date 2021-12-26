package com.sofka.colciclapp.domain.vigia.values;

import co.com.sofka.domain.generic.Identity;

public class MotoId extends Identity {

    public MotoId() {

    }

    private MotoId(String id) {
        super(id);
    }

    public static MotoId of(String id) {
        return new MotoId(id);
    }
}
