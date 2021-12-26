package com.sofka.colciclapp.domain.recorrido.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.colciclapp.domain.recorrido.values.DetalleFactura;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public class AgregarDetalleAFacturaCommand extends Command {

    private final RecorridoId recorridoId;
    private final DetalleFactura detalleFactura;

    public AgregarDetalleAFacturaCommand(RecorridoId recorridoId, DetalleFactura detalleFactura) {

        this.recorridoId = recorridoId;
        this.detalleFactura = detalleFactura;
    }

    public RecorridoId getRecorridoId() {
        return recorridoId;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }
}
