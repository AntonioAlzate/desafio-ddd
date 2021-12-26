package com.sofka.colciclapp.domain.vigia;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;
import com.sofka.colciclapp.domain.vigia.values.MarcaMoto;
import com.sofka.colciclapp.domain.vigia.values.MotoId;
import com.sofka.colciclapp.domain.vigia.values.TipoMoto;

import java.util.Objects;

public class Moto extends Entity<MotoId> {

    private TipoMoto tipo;
    private MarcaMoto marca;
    private ColorVehiculo color;

    public Moto(MotoId entityId, TipoMoto tipo, MarcaMoto marca, ColorVehiculo color) {
        super(entityId);
        this.tipo = Objects.requireNonNull(tipo, "el tipo es requerido");
        this.marca = Objects.requireNonNull(marca, "la marca es requerida");
        this.color = Objects.requireNonNull(color, "el color es requerido");
    }

    public void actualizarTipoMoto(TipoMoto tipo) {
        this.tipo = Objects.requireNonNull(tipo);
    }

    public void actualizarMarca(MarcaMoto marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    public void actualizarColor(ColorVehiculo color) {
        this.color = Objects.requireNonNull(color);
    }

    public TipoMoto tipo() {
        return tipo;
    }

    public MarcaMoto marca() {
        return marca;
    }

    public ColorVehiculo color() {
        return color;
    }
}
