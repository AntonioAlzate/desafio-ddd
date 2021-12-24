package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.vigia.values.MarcaMoto;
import com.sofka.colciclapp.vigia.values.MotoId;

public class MarcaDeMotoActualizada extends DomainEvent {
    private final MotoId motoId;
    private final MarcaMoto marca;

    public MarcaDeMotoActualizada(MotoId motoId, MarcaMoto marca) {
        super("sofka.vigia.marcamotoactualizada");
        this.motoId = motoId;
        this.marca = marca;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public MarcaMoto getMarca() {
        return marca;
    }
}
