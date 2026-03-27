package com.vehiculos.repositorio;

import com.vehiculos.modelo.Vehiculo;
import com.vehiculos.modelo.AutoMovil;
import com.vehiculos.modelo.Motocicleta;
import com.vehiculos.modelo.CamionCarga;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repositorio en memoria — simula una base de datos.
 * ENCAPSULAMIENTO: la lista interna nunca se expone directamente.
 */
@Repository
public class VehiculoRepositorio {

    private final Map<String, Vehiculo> almacen = new LinkedHashMap<>();

    // ── Datos de demostración al arrancar ────────────────────
    public VehiculoRepositorio() {
        guardar(new AutoMovil("ABC-123", "Toyota",   "Corolla",  2020, 80_000,  4));
        guardar(new AutoMovil("DEF-456", "Mazda",    "MX-5",     2022, 120_000, 2));
        guardar(new Motocicleta("MKL-789", "Honda",    "CB 150",   2021, 40_000,  150));
        guardar(new Motocicleta("XYZ-999", "Kawasaki", "Ninja 650",2023, 100_000, 650));
        guardar(new CamionCarga("TRK-001", "Kenworth", "T800",     2019, 200_000, 12.5));
    }

    public List<Vehiculo> findAll() {
        return new ArrayList<>(almacen.values());
    }

    public Optional<Vehiculo> findByPlaca(String placa) {
        return Optional.ofNullable(almacen.get(placa.toUpperCase()));
    }

    public Vehiculo guardar(Vehiculo v) {
        almacen.put(v.getPlaca().toUpperCase(), v);
        return v;
    }

    public boolean eliminar(String placa) {
        return almacen.remove(placa.toUpperCase()) != null;
    }

    public boolean existePorPlaca(String placa) {
        return almacen.containsKey(placa.toUpperCase());
    }
}
