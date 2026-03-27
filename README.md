# 🚗 GestionVehículos — Spring Boot + Tailwind CSS

Proyecto full-stack que demuestra los **4 pilares de la POO en Java**
con una API REST en Spring Boot y un frontend moderno en HTML + Tailwind CSS.

---

## 🗂️ Estructura del proyecto

```
GestionVehiculos-Full/
├── backend/                          ← Java Spring Boot (API REST)
│   ├── pom.xml
│   └── src/main/java/com/vehiculos/
│       ├── GestionVehiculosApplication.java   ← Arranque Spring Boot
│       ├── modelo/
│       │   ├── Vehiculo.java          ← Clase abstracta (Abstracción + Encapsulamiento)
│       │   ├── Asegurable.java        ← Interfaz
│       │   ├── AutoMovil.java         ← Subclase (Herencia + Polimorfismo)
│       │   ├── Motocicleta.java       ← Subclase
│       │   └── CamionCarga.java       ← Subclase
│       ├── repositorio/
│       │   └── VehiculoRepositorio.java       ← Almacén en memoria
│       ├── servicio/
│       │   └── VehiculoServicio.java          ← Lógica de negocio
│       └── controlador/
│           └── VehiculoControlador.java       ← Endpoints REST
└── frontend/
    └── index.html                    ← HTML + Tailwind CSS + JS Vanilla
```

---

## 🧩 Pilares POO implementados

| Pilar | Dónde |
|-------|-------|
| **Encapsulamiento** | Atributos `private` en `Vehiculo`, acceso solo por getters/setters con validación |
| **Abstracción** | `Vehiculo` es `abstract`, interfaz `Asegurable` define contratos |
| **Herencia** | `AutoMovil`, `Motocicleta`, `CamionCarga` extienden `Vehiculo` con `super()` |
| **Polimorfismo** | `calcularTarifaDiaria()` se comporta diferente en cada subclase; el servicio trabaja con `Vehiculo` genérico |

---

## 🔌 Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET    | `/api/vehiculos` | Listar todos |
| GET    | `/api/vehiculos/{placa}` | Buscar por placa |
| POST   | `/api/vehiculos/automovil` | Crear automóvil |
| POST   | `/api/vehiculos/motocicleta` | Crear motocicleta |
| POST   | `/api/vehiculos/camion` | Crear camión |
| PUT    | `/api/vehiculos/{placa}` | Actualizar vehículo |
| DELETE | `/api/vehiculos/{placa}` | Eliminar vehículo |
| GET    | `/api/vehiculos/{placa}/cotizar?dias=N` | Cotizar alquiler |

---

## ▶️ Cómo ejecutar

### 1. Backend (Spring Boot)

**Opción A — IntelliJ IDEA**
1. Abre la carpeta `backend/` como proyecto Maven.
2. Espera a que IntelliJ descargue las dependencias.
3. Ejecuta `GestionVehiculosApplication.java` → botón ▶.
4. La API estará en `http://localhost:8080`.

**Opción B — Terminal**
```bash
cd backend
./mvnw spring-boot:run
```
*(Requiere Maven Wrapper incluido o Maven instalado globalmente)*

### 2. Frontend (HTML)

Una vez el backend esté corriendo:

**Opción A — Abrir directo**
- Abre `frontend/index.html` con doble clic en tu explorador de archivos.
- El navegador lo abrirá como `file://...` y se conectará al backend en `localhost:8080`.

**Opción B — Servidor local (recomendado)**
```bash
cd frontend
# Con Python
python -m http.server 5500
# Con Node
npx serve .
```
Luego abre `http://localhost:5500`.

---

## 🔧 Requisitos

- **Java 21** (o 17 mínimo)
- **Maven** (o usar el wrapper `./mvnw` incluido)
- Navegador moderno (Chrome, Firefox, Edge)
- Conexión a internet para cargar Tailwind CSS desde CDN

---

## 📋 Funcionalidades del frontend

- ✅ Registrar AutoMóvil, Motocicleta y Camión de Carga
- ✅ Tabla con todos los vehículos registrados
- ✅ Modal de detalle por vehículo
- ✅ Edición inline (el formulario se precarga)
- ✅ Eliminación con confirmación
- ✅ Cotizador de alquiler con cálculo polimórfico
- ✅ Indicador de estado de conexión al backend
- ✅ Estadísticas en tiempo real (total, autos, motos, camiones)
- ✅ Diseño responsive (desktop + móvil)
# Gestion-vehicular-JAVA-
