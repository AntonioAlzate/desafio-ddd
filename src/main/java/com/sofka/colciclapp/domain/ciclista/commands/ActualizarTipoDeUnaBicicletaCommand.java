package com.sofka.colciclapp.domain.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.CiclistaId;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;

public class ActualizarTipoDeUnaBicicletaCommand extends Command {

    private final CiclistaId ciclistaId;
    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipo;

    public ActualizarTipoDeUnaBicicletaCommand(CiclistaId ciclistaId, BicicletaId bicicletaId, TipoBicicleta tipo) {

        this.ciclistaId = ciclistaId;
        this.bicicletaId = bicicletaId;
        this.tipo = tipo;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public TipoBicicleta getTipo() {
        return tipo;
    }
}
