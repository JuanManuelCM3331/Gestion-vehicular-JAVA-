package com.vehiculos.modelo;

/**
 * HERENCIA: extiende Vehiculo
 * POLIMORFISMO: redefine calcularTarifaDiaria() y getTipo()
 * INTERFAZ: implementa Asegurable
 */
public class AutoMovil extends Vehiculo implements Asegurable {

    private int numeroPuertas;

    // ── CONSTRUCTOR COMPLETO ─────────────────────────────────
    public AutoMovil(String placa, String marca, String modelo,
                     int anio, double precioBase, int numeroPuertas) {
        super(placa, marca, modelo, anio, precioBase);
        this.numeroPuertas = numeroPuertas;
    }

    // ── CONSTRUCTOR POR DEFECTO ──────────────────────────────
    public AutoMovil() { super(); this.numeroPuertas = 4; }

    // ── POLIMORFISMO ─────────────────────────────────────────
    @Override
    public double calcularTarifaDiaria() {
        return getPrecioBase() * 1.15;  // +15% recargo automóvil
    }

    @Override
    public String getTipo() { return "AUTOMOVIL"; }

    // ── INTERFAZ Asegurable ──────────────────────────────────
    @Override public double  calcularSeguro()       { return getPrecioBase() * 0.08; }
    @Override public String  getTipoSeguro()        { return "Todo Riesgo"; }
    @Override public boolean requiereInspeccion()   { return getAnio() < 2015; }

    // ── GETTER / SETTER ──────────────────────────────────────
    public int getNumeroPuertas() { return numeroPuertas; }
    public void setNumeroPuertas(int numeroPuertas) {
        if (numeroPuertas != 2 && numeroPuertas != 4)
            throw new IllegalArgumentException("Solo 2 o 4 puertas.");
        this.numeroPuertas = numeroPuertas;
    }
}
