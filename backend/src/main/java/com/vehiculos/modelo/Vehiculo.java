package com.vehiculos.modelo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ============================================================
 *  ABSTRACCIÓN + ENCAPSULAMIENTO
 *  Clase abstracta base. No puede instanciarse directamente.
 *  Jackson usa @JsonTypeInfo para serializar subclases a JSON.
 * ============================================================
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AutoMovil.class,    name = "AUTOMOVIL"),
    @JsonSubTypes.Type(value = Motocicleta.class,  name = "MOTOCICLETA"),
    @JsonSubTypes.Type(value = CamionCarga.class,  name = "CAMION")
})
public abstract class Vehiculo {

    // ── ENCAPSULAMIENTO: atributos privados ──────────────────
    private String placa;
    private String marca;
    private String modelo;
    private int    anio;
    private double precioBase;

    // ── CONSTRUCTOR COMPLETO ─────────────────────────────────
    public Vehiculo(String placa, String marca, String modelo,
                    int anio, double precioBase) {
        this.placa      = placa != null ? placa.toUpperCase() : "";
        this.marca      = marca;
        this.modelo     = modelo;
        this.anio       = anio;
        this.precioBase = precioBase;
    }

    // ── CONSTRUCTOR POR DEFECTO (requerido por Jackson) ──────
    public Vehiculo() {}

    // ── MÉTODOS ABSTRACTOS (Abstracción + Polimorfismo) ──────
    public abstract double calcularTarifaDiaria();
    public abstract String getTipo();

    // ── MÉTODOS CONCRETOS COMPARTIDOS ────────────────────────
    public double calcularCostoAlquiler(int dias) {
        return calcularTarifaDiaria() * dias;
    }

    public String getDescripcion() {
        return String.format("%s %s (%d)", marca, modelo, anio);
    }

    // ── GETTERS Y SETTERS (Encapsulamiento) ──────────────────
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        this.placa = placa.toUpperCase();
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) {
        if (anio < 1900 || anio > 2100)
            throw new IllegalArgumentException("Año inválido: " + anio);
        this.anio = anio;
    }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) {
        if (precioBase < 0)
            throw new IllegalArgumentException("El precio base no puede ser negativo.");
        this.precioBase = precioBase;
    }
}
