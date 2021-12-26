package com.sofka.colciclapp.domain.recorrido.values;

import co.com.sofka.domain.generic.Identity;

public class RecorridoId extends Identity {

    public RecorridoId() {

    }

    private RecorridoId(String id) {
        super(id);
    }

    public static RecorridoId of(String id) {
        return new RecorridoId(id);
    }
}
