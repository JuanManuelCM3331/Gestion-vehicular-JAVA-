package com.vehiculos.controlador;

import com.vehiculos.modelo.*;
import com.vehiculos.servicio.VehiculoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * API REST — expone los endpoints para el frontend.
 * @CrossOrigin permite peticiones desde el frontend HTML.
 */
@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoControlador {

    private final VehiculoServicio servicio;

    public VehiculoControlador(VehiculoServicio servicio) {
        this.servicio = servicio;
    }

    // GET /api/vehiculos — listar todos
    @GetMapping
    public List<Vehiculo> listarTodos() {
        return servicio.listarTodos();
    }

    // GET /api/vehiculos/{placa} — buscar por placa
    @GetMapping("/{placa}")
    public ResponseEntity<?> buscar(@PathVariable String placa) {
        return servicio.buscarPorPlaca(placa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/vehiculos/automovil
    @PostMapping("/automovil")
    public ResponseEntity<?> crearAuto(@RequestBody AutoMovil auto) {
        try {
            return ResponseEntity.ok(servicio.crear(auto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // POST /api/vehiculos/motocicleta
    @PostMapping("/motocicleta")
    public ResponseEntity<?> crearMoto(@RequestBody Motocicleta moto) {
        try {
            return ResponseEntity.ok(servicio.crear(moto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // POST /api/vehiculos/camion
    @PostMapping("/camion")
    public ResponseEntity<?> crearCamion(@RequestBody CamionCarga camion) {
        try {
            return ResponseEntity.ok(servicio.crear(camion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // PUT /api/vehiculos/{placa} — actualizar
    @PutMapping("/{placa}")
    public ResponseEntity<?> actualizar(@PathVariable String placa,
                                        @RequestBody Vehiculo vehiculo) {
        try {
            return ResponseEntity.ok(servicio.actualizar(placa, vehiculo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // DELETE /api/vehiculos/{placa}
    @DeleteMapping("/{placa}")
    public ResponseEntity<?> eliminar(@PathVariable String placa) {
        boolean ok = servicio.eliminar(placa);
        return ok ? ResponseEntity.ok(Map.of("mensaje", "Vehículo eliminado"))
                  : ResponseEntity.notFound().build();
    }

    // GET /api/vehiculos/{placa}/cotizar?dias=5
    @GetMapping("/{placa}/cotizar")
    public ResponseEntity<?> cotizar(@PathVariable String placa,
                                     @RequestParam(defaultValue = "1") int dias) {
        try {
            return ResponseEntity.ok(servicio.cotizar(placa, dias));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
