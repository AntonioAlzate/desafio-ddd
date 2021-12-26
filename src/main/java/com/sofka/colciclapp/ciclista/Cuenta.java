package com.sofka.colciclapp.ciclista;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.ciclista.values.CuentaId;
import com.sofka.colciclapp.ciclista.values.Favorito;

import java.util.Objects;
import java.util.Set;

public class Cuenta extends Entity<CuentaId> {
    private Set<Favorito> favoritos;

    public Cuenta(CuentaId entityId) {
        super(entityId);
    }

    public void agregarFavorito(Favorito favorito){
        Objects.requireNonNull(favorito, "El favorito no puede ser nulo");
        if(favoritos.contains(favorito)){
            throw new IllegalArgumentException("Ya se encuentra agregado comno favorito");
        }

        favoritos.add(favorito);
    }

    public void quitarFavorito(Favorito favorito){
        Objects.requireNonNull(favorito, "El favorito no puede ser nulo");
        if(!favoritos.contains(favorito)){
            throw new IllegalArgumentException("El favorito a eliminar no fue encontrado");
        }

        favoritos.remove(favorito);
    }

    public Set<Favorito> favoritos() {
        return favoritos;
    }
}
