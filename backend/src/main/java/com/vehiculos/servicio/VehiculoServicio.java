package com.vehiculos.servicio;

import com.vehiculos.modelo.*;
import com.vehiculos.repositorio.VehiculoRepositorio;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Capa de servicio — lógica de negocio.
 * POLIMORFISMO: trabaja con Vehiculo sin conocer la subclase concreta.
 */
@Service
public class VehiculoServicio {

    private final VehiculoRepositorio repositorio;

    // ── Inyección de dependencias (constructor) ──────────────
    public VehiculoServicio(VehiculoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Vehiculo> listarTodos() {
        return repositorio.findAll();
    }

    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return repositorio.findByPlaca(placa);
    }

    public Vehiculo crear(Vehiculo v) {
        if (repositorio.existePorPlaca(v.getPlaca()))
            throw new IllegalStateException("Ya existe un vehículo con placa: " + v.getPlaca());
        return repositorio.guardar(v);
    }

    public Vehiculo actualizar(String placa, Vehiculo nuevo) {
        Vehiculo existente = repositorio.findByPlaca(placa)
                .orElseThrow(() -> new NoSuchElementException("Vehículo no encontrado: " + placa));
        // Setters con validación (Encapsulamiento)
        existente.setMarca(nuevo.getMarca());
        existente.setModelo(nuevo.getModelo());
        existente.setAnio(nuevo.getAnio());
        existente.setPrecioBase(nuevo.getPrecioBase());
        return repositorio.guardar(existente);
    }

    public boolean eliminar(String placa) {
        return repositorio.eliminar(placa);
    }

    /** Cotización de alquiler — usa polimorfismo en calcularCostoAlquiler() */
    public Map<String, Object> cotizar(String placa, int dias) {
        Vehiculo v = repositorio.findByPlaca(placa)
                .orElseThrow(() -> new NoSuchElementException("Vehículo no encontrado: " + placa));
        Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("placa",          v.getPlaca());
        resp.put("descripcion",    v.getDescripcion());
        resp.put("tipo",           v.getTipo());
        resp.put("tarifaDiaria",   v.calcularTarifaDiaria());       // polimorfismo
        resp.put("dias",           dias);
        resp.put("costoTotal",     v.calcularCostoAlquiler(dias));  // polimorfismo
        // Seguro si aplica
        if (v instanceof Asegurable a) {
            resp.put("tipoSeguro",        a.getTipoSeguro());
            resp.put("seguroMensual",     a.calcularSeguro());
            resp.put("requiereInspeccion", a.requiereInspeccion());
        }
        return resp;
    }
}
