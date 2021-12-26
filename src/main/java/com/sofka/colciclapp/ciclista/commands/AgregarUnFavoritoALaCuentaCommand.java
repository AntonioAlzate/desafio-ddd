package com.sofka.colciclapp.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.ciclista.values.CiclistaId;
import com.sofka.colciclapp.ciclista.values.Favorito;

public class AgregarUnFavoritoALaCuentaCommand extends Command {

    private final CiclistaId ciclistaId;
    private final Favorito favorito;

    public AgregarUnFavoritoALaCuentaCommand(CiclistaId ciclistaId, Favorito favorito){

        this.ciclistaId = ciclistaId;
        this.favorito = favorito;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
    }

    public Favorito getFavorito() {
        return favorito;
    }
}
