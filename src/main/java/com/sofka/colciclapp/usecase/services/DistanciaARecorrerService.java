package com.sofka.colciclapp.usecase.services;

import com.sofka.colciclapp.domain.recorrido.values.Direccion;
import com.sofka.colciclapp.domain.recorrido.values.RecorridoId;

public interface DistanciaARecorrerService {

    Double calcularDistancia(RecorridoId recorridoId, Direccion direccionOrigen, Direccion direccionDestino);
}
