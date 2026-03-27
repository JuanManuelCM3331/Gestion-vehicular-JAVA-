package com.vehiculos.modelo;

/**
 * HERENCIA: extiende Vehiculo
 * POLIMORFISMO: redefine calcularTarifaDiaria() y getTipo()
 * INTERFAZ: implementa Asegurable
 */
public class Motocicleta extends Vehiculo implements Asegurable {

    private int cilindraje;

    public Motocicleta(String placa, String marca, String modelo,
                       int anio, double precioBase, int cilindraje) {
        super(placa, marca, modelo, anio, precioBase);
        this.cilindraje = cilindraje;
    }

    public Motocicleta() { super(); }

    @Override
    public double calcularTarifaDiaria() {
        double tarifa = getPrecioBase() * 0.80;
        if (cilindraje > 400) tarifa *= 1.10;
        return tarifa;
    }

    @Override public String getTipo() { return "MOTOCICLETA"; }

    @Override public double  calcularSeguro()     { return getPrecioBase() * 0.05; }
    @Override public String  getTipoSeguro()      { return cilindraje > 400 ? "Premium Moto" : "Básico Moto"; }
    @Override public boolean requiereInspeccion() { return cilindraje > 500; }

    public int getCilindraje() { return cilindraje; }
    public void setCilindraje(int cilindraje) {
        if (cilindraje <= 0) throw new IllegalArgumentException("Cilindraje debe ser positivo.");
        this.cilindraje = cilindraje;
    }
}
