package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.vigia.values.MotoId;
import com.sofka.colciclapp.vigia.values.TipoMoto;

public class TipoDeMotoActualizada extends DomainEvent {
    private final MotoId motoId;
    private final TipoMoto tipo;

    public TipoDeMotoActualizada(MotoId motoId, TipoMoto tipo) {
        super("sofka.vigia.tipomotoactualizada");
        this.motoId = motoId;
        this.tipo = tipo;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public TipoMoto getTipo() {
        return tipo;
    }
}
