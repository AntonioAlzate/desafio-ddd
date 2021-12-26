package com.sofka.colciclapp.ciclista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.ciclista.values.BicicletaId;
import com.sofka.colciclapp.ciclista.values.CiclistaId;
import com.sofka.colciclapp.ciclista.values.MarcaBicicleta;

public class ActualizarMarcaDeUnaBicicletaCommand extends Command {

    private final CiclistaId ciclistaId;
    private final BicicletaId bicicletaId;
    private final MarcaBicicleta marca;

    public ActualizarMarcaDeUnaBicicletaCommand(CiclistaId ciclistaId, BicicletaId bicicletaId, MarcaBicicleta marca){

        this.ciclistaId = ciclistaId;
        this.bicicletaId = bicicletaId;
        this.marca = marca;
    }

    public CiclistaId getCiclistaId() {
        return ciclistaId;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public MarcaBicicleta getMarca() {
        return marca;
    }
}
