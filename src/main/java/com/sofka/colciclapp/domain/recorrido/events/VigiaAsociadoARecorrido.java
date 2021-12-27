package com.sofka.colciclapp.domain.recorrido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class VigiaAsociadoARecorrido extends DomainEvent {
    private final VigiaId vigiaId;

    public VigiaAsociadoARecorrido(VigiaId vigiaId) {
        super("sofka.recorrido.vigiaasociado");
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }
}
