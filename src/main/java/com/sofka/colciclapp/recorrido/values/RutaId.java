package com.sofka.colciclapp.recorrido.values;

import co.com.sofka.domain.generic.Identity;

public class RutaId extends Identity {

    public RutaId(){

    }

    private RutaId(String id){
        super(id);
    }

    public static RutaId of(String id){
        return new RutaId(id);
    }
}
