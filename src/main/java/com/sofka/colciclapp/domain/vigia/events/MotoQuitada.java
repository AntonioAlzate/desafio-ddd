package com.sofka.colciclapp.domain.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.vigia.values.MotoId;

public class MotoQuitada extends DomainEvent {
    private final MotoId motoId;

    public MotoQuitada(MotoId motoId) {
        super("sofka.vigia.motoquitada");
        this.motoId = motoId;
    }

    public MotoId getMotoId() {
        return motoId;
    }
}
