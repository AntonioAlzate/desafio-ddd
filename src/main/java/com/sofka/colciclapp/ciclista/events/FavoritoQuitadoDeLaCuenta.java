package com.sofka.colciclapp.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.ciclista.values.Favorito;

public class FavoritoQuitadoDeLaCuenta extends DomainEvent {
    private final Favorito favorito;

    public FavoritoQuitadoDeLaCuenta(Favorito favorito) {
        super("sofka.ciclista.favoritoquitadocuenta");
        this.favorito = favorito;
    }

    public Favorito getFavorito() {
        return favorito;
    }
}
