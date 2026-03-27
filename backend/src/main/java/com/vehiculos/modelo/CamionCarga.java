package com.vehiculos.modelo;

/**
 * HERENCIA: extiende Vehiculo
 * POLIMORFISMO: redefine calcularTarifaDiaria() y getTipo()
 */
public class CamionCarga extends Vehiculo {

    private double capacidadToneladas;

    public CamionCarga(String placa, String marca, String modelo,
                       int anio, double precioBase, double capacidadToneladas) {
        super(placa, marca, modelo, anio, precioBase);
        this.capacidadToneladas = capacidadToneladas;
    }

    public CamionCarga() { super(); }

    @Override
    public double calcularTarifaDiaria() {
        return getPrecioBase() + (capacidadToneladas * 15_000);
    }

    @Override public String getTipo() { return "CAMION"; }

    public double getCapacidadToneladas() { return capacidadToneladas; }
    public void setCapacidadToneladas(double t) {
        if (t <= 0) throw new IllegalArgumentException("Capacidad debe ser positiva.");
        this.capacidadToneladas = t;
    }
}
