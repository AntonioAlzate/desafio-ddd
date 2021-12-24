package com.sofka.colciclapp.vigia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.colciclapp.genericos.Color;
import com.sofka.colciclapp.vigia.values.MotoId;

public class ColorDeMotoActualizada extends DomainEvent {
    private final MotoId motoId;
    private final Color color;

    public ColorDeMotoActualizada(MotoId motoId, Color color) {
        super("sofka.vigia.colormotoactualizado");
        this.motoId = motoId;
        this.color = color;
    }

    public MotoId getMotoId() {
        return motoId;
    }

    public Color getColor() {
        return color;
    }
}
