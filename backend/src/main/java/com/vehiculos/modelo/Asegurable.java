package com.vehiculos.modelo;

/**
 * ABSTRACCIÓN mediante INTERFAZ
 * Contrato para vehículos que pueden ser asegurados.
 */
public interface Asegurable {
    double  calcularSeguro();
    String  getTipoSeguro();
    boolean requiereInspeccion();
}
