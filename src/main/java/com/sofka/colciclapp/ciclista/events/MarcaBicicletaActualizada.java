package com.sofka.colciclapp.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.ciclista.values.BicicletaId;
import com.sofka.colciclapp.ciclista.values.MarcaBicicleta;

public class MarcaBicicletaActualizada extends DomainEvent {
    private final BicicletaId bicicletaId;
    private final MarcaBicicleta marca;

    public MarcaBicicletaActualizada(BicicletaId bicicletaId, MarcaBicicleta marca) {
        super("sofka.ciclista.marcabicicletaactualizada");
        this.bicicletaId = bicicletaId;
        this.marca = marca;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public MarcaBicicleta getMarca() {
        return marca;
    }
}
