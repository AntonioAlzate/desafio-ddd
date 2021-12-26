package com.sofka.colciclapp.domain.ciclista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;

public class TipoBicicletaActualizada extends DomainEvent {
    private final BicicletaId bicicletaId;
    private final TipoBicicleta tipo;

    public TipoBicicletaActualizada(BicicletaId bicicletaId, TipoBicicleta tipo) {
        super("sofka.ciclista.tipobicicletaactualizada");
        this.bicicletaId = bicicletaId;
        this.tipo = tipo;
    }

    public BicicletaId getBicicletaId() {
        return bicicletaId;
    }

    public TipoBicicleta getTipo() {
        return tipo;
    }
}
