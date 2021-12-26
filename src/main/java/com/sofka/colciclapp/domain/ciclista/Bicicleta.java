package com.sofka.colciclapp.domain.ciclista;

import co.com.sofka.domain.generic.Entity;
import com.sofka.colciclapp.domain.ciclista.values.BicicletaId;
import com.sofka.colciclapp.domain.ciclista.values.MarcaBicicleta;
import com.sofka.colciclapp.domain.ciclista.values.TipoBicicleta;
import com.sofka.colciclapp.domain.genericos.ColorVehiculo;

import java.util.Objects;

public class Bicicleta extends Entity<BicicletaId> {

    private TipoBicicleta tipoBicicleta;
    private MarcaBicicleta marca;
    private ColorVehiculo color;

    public Bicicleta(BicicletaId entityId, TipoBicicleta tipoBicicleta, MarcaBicicleta marca, ColorVehiculo color) {
        super(entityId);
        this.tipoBicicleta = Objects.requireNonNull(tipoBicicleta);
        this.marca = Objects.requireNonNull(marca);
        this.color = Objects.requireNonNull(color);
    }

    public void actualizarTipoBicicleta(TipoBicicleta tipoBicicleta) {
        this.tipoBicicleta = Objects.requireNonNull(tipoBicicleta, "el tipo de bicicleta es requerido");
    }

    public void actualizarMarca(MarcaBicicleta marca) {
        this.marca = Objects.requireNonNull(marca, "la marca es requerida");
    }

    public void actualizarColor(ColorVehiculo color) {
        this.color = Objects.requireNonNull(color, "El color de la bicicleta es requerido");
    }

    public TipoBicicleta tipoBicicleta() {
        return tipoBicicleta;
    }

    public MarcaBicicleta marca() {
        return marca;
    }

    public ColorVehiculo color() {
        return color;
    }
}
