package com.sofka.colciclapp.domain.vigia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.vigia.values.MarcaMoto;
import com.sofka.colciclapp.domain.vigia.values.MotoId;
import com.sofka.colciclapp.domain.vigia.values.TipoMoto;
import com.sofka.colciclapp.domain.vigia.values.VigiaId;

public class AgregarMotoCommand extends Command {

    private final MotoId entityId;
    private final TipoMoto tipo;
    private final MarcaMoto marca;
    private final ColorVehiculo color;
    private final VigiaId vigiaId;

    public AgregarMotoCommand(VigiaId vigiaId, MotoId entityId, TipoMoto tipo, MarcaMoto marca, ColorVehiculo color) {
        this.entityId = entityId;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
        this.vigiaId = vigiaId;
    }

    public VigiaId getVigiaId() {
        return vigiaId;
    }

    public MotoId getEntityId() {
        return entityId;
    }

    public TipoMoto getTipo() {
        return tipo;
    }

    public MarcaMoto getMarca() {
        return marca;
    }

    public ColorVehiculo getColor() {
        return color;
    }
}
