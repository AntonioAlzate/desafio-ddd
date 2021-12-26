package com.sofka.colciclapp.domain.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.ciclista.values.Favorito;

public class QuitarUnFavoritoDeLaCuentaCommand extends Command {

    private final CiclistaId ciclistaId;
    private final Favorito favorito;

    public QuitarUnFavoritoDeLaCuentaCommand(CiclistaId ciclistaId, Favorito favorito) {
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
