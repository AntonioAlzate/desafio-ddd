package com.sofka.colciclapp.domain.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.values.Favorito;

public class FavoritoAgregadoALaCuenta extends DomainEvent {
    private final Favorito favorito;

    public FavoritoAgregadoALaCuenta(Favorito favorito) {
        super("sofka.ciclista.favoritoagregadocuenta");
        this.favorito = favorito;
    }

    public Favorito getFavorito() {
        return favorito;
    }
}
