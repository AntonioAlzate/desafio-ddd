package com.sofka.colciclapp.recorrido.values;

import co.com.sofka.domain.generic.Identity;

public class ServicioId extends Identity {

    public ServicioId(){

    }

    private ServicioId(String id){
        super(id);
    }

    public static ServicioId of(String id){
        return new ServicioId(id);
    }
}
