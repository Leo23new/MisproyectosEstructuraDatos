# 🏢 HOJA DE RUTA - SISTEMA DE GESTIÓN COMERCIAL INTEGRADO
## Aplicación de Control, Automatización y Escalabilidad para Tienda Minorista

**Versión:** 1.0 | **Fecha:** Junio 2026 | **Estado:** Planificación MVP

---

## 📋 TABLA DE CONTENIDOS
1. [Análisis de Negocio](#análisis-de-negocio)
2. [Visión y Objetivos](#visión-y-objetivos)
3. [Definición del MVP](#definición-del-mvp)
4. [Arquitectura del Sistema](#arquitectura-del-sistema)
5. [Modelo de Base de Datos](#modelo-de-base-de-datos)
6. [Stack Tecnológico](#stack-tecnológico)
7. [Fases de Desarrollo](#fases-de-desarrollo)
8. [Métricas de Éxito](#métricas-de-éxito)

---

## 1. ANÁLISIS DE NEGOCIO

### 1.1 Líneas de Negocio

#### **Línea 1: Productos Tecnológicos y Papelería**
- Accesorios para teléfonos (cables, protectores, fundas, etc.)
- Componentes electrónicos
- Artículos de papelería
- **Características:** Inventario discreto, código de barras, rotación variable

#### **Línea 2: Servicios Documentales Digitales**
- Redacción de documentos
- Tramitología (solicitudes administrativas)
- Elaboración de hojas de vida
- **Características:** Servicios bajo demanda, tiempo variable, alto margen

### 1.2 Dolor Actual
- ❌ No hay visibilidad en tiempo real de inventario
- ❌ Decisiones basadas en intuición, no en datos
- ❌ Procesos manuales y propensos a errores
- ❌ Imposibilidad de escalar eficientemente
- ❌ No hay análisis de ROI en campañas
- ❌ Gestión fragmentada de servicios vs productos

---

## 2. VISIÓN Y OBJETIVOS

### 2.1 Visión General
**"Una plataforma integral que centralice toda la operación comercial, proporcionando inteligencia de negocios en tiempo real para facilitar toma de decisiones autónoma, eficiente y escalable."**

### 2.2 Objetivos Primarios

| Objetivo | Métrica | Plazo |
|----------|---------|-------|
| Control de inventario en tiempo real | 100% de productos trackeados | Mes 2 |
| Dashboard de KPIs operativos | 15+ indicadores clave | Mes 2 |
| Automatización de procesos | 40% reducción en tiempo manual | Mes 3 |
| Recomendaciones estratégicas | 1 sugerencia por día | Mes 4 |
| Escalabilidad horizontal | Capaz de soportar 5x volumen actual | Mes 6 |

### 2.3 Objetivos Secundarios
- Mejorar experiencia del cliente (autoservicio)
- Reducir costos operativos 25%
- Aumentar márgenes de ganancia 15%
- Generar capacidad para múltiples sucursales (futuro)

---

## 3. DEFINICIÓN DEL MVP

### 3.1 Alcance MVP (Fase 1 - 8-10 semanas)

#### ✅ INCLUIDO EN MVP

**Módulo 1: Gestión de Inventario**
- [ ] Catálogo de productos (nombre, SKU, categoría, precio costo, precio venta)
- [ ] Entrada/salida de stock manual
- [ ] Alertas de bajo stock (umbral configurable)
- [ ] Código de barras (lectura básica via input)
- [ ] Historial de movimientos

**Módulo 2: Punto de Venta (POS) Simplificado**
- [ ] Interfaz de venta rápida (selección de productos)
- [ ] Cálculo automático de descuentos por volumen
- [ ] Registro de transacciones
- [ ] Recibos digitales
- [ ] Integración con inventario (decrementar stock)

**Módulo 3: Gestión de Servicios Documentales**
- [ ] Creación de solicitudes de servicio
- [ ] Estados: Pendiente, En Proceso, Completado, Entregado
- [ ] Asignación de precios por servicio
- [ ] Registro de entregas
- [ ] Historial de servicios por cliente

**Módulo 4: Dashboard de KPIs Básicos**
- [ ] Ventas diarias/semanales/mensuales
- [ ] Producto más vendido
- [ ] Ingresos por línea (Productos vs Servicios)
- [ ] Inventario actual (valor total)
- [ ] Margen bruto promedio

**Módulo 5: Gestión de Usuarios**
- [ ] Autenticación segura (email/contraseña)
- [ ] Roles: Propietario, Vendedor, Administrador
- [ ] Historial de acciones por usuario

#### ❌ EXCLUIDO DE MVP (Fases posteriores)

- Inteligencia artificial avanzada
- Integración con redes sociales
- Sistema de múltiples sucursales
- Facturación fiscal completa
- Análisis predictivo
- App móvil nativa
- POS con hardware específico (lector de códigos de barras profesional)

### 3.2 Historias de Usuario MVP

```
US-001: Como vendedor, quiero registrar una venta rápidamente
        para procesar transacciones sin demoras

US-002: Como propietario, quiero ver el inventario en tiempo real
        para saber qué tengo disponible

US-003: Como propietario, quiero alertas de bajo stock
        para reponer productos a tiempo

US-004: Como cliente/trabajador de servicio, quiero solicitar un trabajo
        para que se registre y se procese

US-005: Como propietario, quiero un dashboard de ventas
        para entender el desempeño del negocio

US-006: Como propietario, quiero ver márgenes de ganancia
        para tomar decisiones de precios

US-007: Como vendedor, quiero acceso limitado a funciones
        para no permitir acceso a datos sensibles
```

---

## 4. ARQUITECTURA DEL SISTEMA

### 4.1 Arquitectura General

```
┌─────────────────────────────────────────────────────────┐
│                    CAPA DE PRESENTACIÓN                 │
│  ┌──────────────────────────────────────────────────┐  │
│  │  React + Tailwind CSS                            │  │
│  │  - Dashboard                                      │  │
│  │  - Módulo POS                                    │  │
│  │  - Gestión de Inventario                         │  │
│  │  - Servicios Documentales                        │  │
│  │  - Reportes                                      │  │
│  └──────────────────────────────────────────────────┘  │
└────────────────────┬────────────────────────────────────┘
                     │ API REST/GraphQL
┌────────────────────▼────────────────────────────────────┐
│                CAPA DE APLICACIÓN                       │
│  ┌──────────────────────────────────────────────────┐  │
│  │  Node.js + Express (Backend)                     │  │
│  │  - Autenticación & Autorización                  │  │
│  │  - Lógica de negocio                             │  │
│  │  - Procesamiento de transacciones                │  │
│  │  - Cálculo de KPIs                               │  │
│  │  - Motor de recomendaciones                      │  │
│  └──────────────────────────────────────────────────┘  │
└────────────────────┬────────────────────────────────────┘
                     │ SDK/Queries
┌────────────────────▼────────────────────────────────────┐
│                CAPA DE DATOS                            │
│  ┌──────────────────────────────────────────────────┐  │
│  │  Supabase (PostgreSQL + Auth + Storage)          │  │
│  │  - Base de datos relacional                      │  │
│  │  - Autenticación                                 │  │
│  │  - Almacenamiento de archivos                    │  │
│  │  - Backups automáticos                           │  │
│  └──────────────────────────────────────────────────┘  │
└──────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────┐
│              SERVICIOS TRANSVERSALES                     │
│  - Logging y Monitoreo (Sentry)                         │
│  - Análisis (Mixpanel / Google Analytics)              │
│  - Email (SendGrid/Resend)                             │
│  - Backup y Disaster Recovery                          │
└──────────────────────────────────────────────────────────┘
```

### 4.2 Flujos de Datos Principales

#### **Flujo de Venta (POS)**
```
Usuario selecciona productos 
  ↓
Sistema calcula subtotal, descuentos, total
  ↓
Usuario confirma pago
  ↓
Sistema registra transacción
  ↓
Stock se decrementa automáticamente
  ↓
Se actualiza dashboard de KPIs
```

#### **Flujo de Solicitud de Servicio**
```
Cliente/trabajador crea solicitud
  ↓
Sistema asigna ID y fecha
  ↓
Admin recibe notificación
  ↓
Se actualiza estado (Pendiente → En Proceso → Completado → Entregado)
  ↓
Ingreso registrado en sistema
  ↓
Se actualiza margen y KPIs
```

#### **Flujo de Reabastecimiento**
```
Stock cae bajo umbral
  ↓
Sistema genera alerta
  ↓
Admin ingresa nuevo stock
  ↓
Costo se registra
  ↓
Margen se recalcula
  ↓
Histórico se actualiza
```

---

## 5. MODELO DE BASE DE DATOS

### 5.1 Diagrama Entidad-Relación (DER)

```
┌─────────────────┐
│     users       │
├─────────────────┤
│ id (PK)         │
│ email           │
│ password_hash   │
│ nombre          │
│ rol             │ ──────────┐
│ activo          │           │
│ created_at      │           │
└─────────────────┘           │
        │                     │
        │ 1:N                 │
        │                     │
        ├─────────────────────┤
        │                     │
        ▼                     │
┌─────────────────┐           │
│  transacciones  │           │
├─────────────────┤           │
│ id (PK)         │           │
│ user_id (FK)    │◄──────────┤
│ tipo            │           │
│ total           │           │
│ descuento       │    ┌──────┤
│ fecha           │    │      │
│ nota            │    │      │
└─────────────────┘    │      │
        │ 1:N          │      │
        │              │      │
        ▼              │      │
┌──────────────────────┤      │
│ items_transaccion    │      │
├──────────────────────┤      │
│ id (PK)              │      │
│ transaccion_id (FK)  │      │
│ producto_id (FK)     │┐     │
│ cantidad             ││     │
│ precio_unitario      ││     │
│ subtotal             ││     │
└──────────────────────┘│     │
                        │     │
        ┌───────────────┘     │
        │                     │
        ▼                     │
┌─────────────────┐           │
│   productos     │           │
├─────────────────┤           │
│ id (PK)         │           │
│ sku             │           │
│ nombre          │           │
│ categoría_id    │┐          │
│ descripción     ││          │
│ precio_costo    ││          │
│ precio_venta    ││          │
│ stock_actual    ││          │
│ stock_minimo    ││          │
│ activo          ││          │
│ created_at      ││          │
└─────────────────┘│          │
        ▲          │          │
        │ 1:N      │          │
        │          │          │
┌───────────────────┤          │
│                   │          │
│   ┌──────────────┘│          │
│   │               │          │
│   ▼               │          │
┌──────────────────────────┐   │
│ movimientos_inventario   │   │
├──────────────────────────┤   │
│ id (PK)                  │   │
│ producto_id (FK)         │   │
│ tipo (entrada/salida)    │   │
│ cantidad                 │   │
│ motivo                   │   │
│ user_id (FK)             │◄──┘
│ created_at               │
└──────────────────────────┘

┌──────────────────┐
│    categorias    │
├──────────────────┤
│ id (PK)          │
│ nombre           │
│ descripción      │
└──────────────────┘

┌──────────────────────────┐
│   servicios_digitales    │
├──────────────────────────┤
│ id (PK)                  │
│ nombre_servicio          │
│ descripción              │
│ precio_base              │
│ tiempo_estimado          │ (horas)
│ activo                   │
│ created_at               │
└──────────────────────────┘

┌──────────────────────────┐
│ solicitudes_servicios    │
├──────────────────────────┤
│ id (PK)                  │
│ servicio_id (FK)         │
│ cliente_nombre           │
│ cliente_contacto         │
│ descripcion              │
│ estado                   │ (Pendiente/En Proceso/
│ precio_final             │  Completado/Entregado)
│ fecha_solicitud          │
│ fecha_entrega            │
│ user_asignado (FK)       │
│ notas                    │
│ created_at               │
└──────────────────────────┘

┌──────────────────────────┐
│   kpis_diarios           │
├──────────────────────────┤
│ id (PK)                  │
│ fecha                    │
│ ventas_total             │
│ cantidad_transacciones   │
│ ticket_promedio          │
│ margen_bruto_pct         │
│ productos_vendidos_cant  │
│ servicios_vendidos_cant  │
│ ingresos_productos       │
│ ingresos_servicios       │
│ created_at               │
└──────────────────────────┘

┌──────────────────────────┐
│   configuracion          │
├──────────────────────────┤
│ id (PK)                  │
│ clave                    │
│ valor                    │
│ tipo                     │
│ descripcion              │
│ updated_at               │
└──────────────────────────┘
```

### 5.2 Definición de Tablas (SQL)

```sql
-- USUARIOS
CREATE TABLE users (
  id UUID PRIMARY KEY DEFAULT auth.uid(),
  email VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  rol VARCHAR(50) NOT NULL CHECK (rol IN ('propietario', 'vendedor', 'admin')),
  activo BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

-- CATEGORÍAS
CREATE TABLE categorias (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL UNIQUE,
  descripcion TEXT,
  created_at TIMESTAMP DEFAULT NOW()
);

-- PRODUCTOS
CREATE TABLE productos (
  id SERIAL PRIMARY KEY,
  sku VARCHAR(50) UNIQUE NOT NULL,
  nombre VARCHAR(150) NOT NULL,
  categoria_id INTEGER REFERENCES categorias(id),
  descripcion TEXT,
  precio_costo DECIMAL(10, 2) NOT NULL,
  precio_venta DECIMAL(10, 2) NOT NULL,
  stock_actual INTEGER DEFAULT 0,
  stock_minimo INTEGER DEFAULT 5,
  activo BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

-- TRANSACCIONES (Ventas)
CREATE TABLE transacciones (
  id SERIAL PRIMARY KEY,
  user_id UUID REFERENCES users(id),
  tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('venta', 'devolucion')),
  total DECIMAL(10, 2) NOT NULL,
  descuento DECIMAL(10, 2) DEFAULT 0,
  fecha TIMESTAMP DEFAULT NOW(),
  nota TEXT,
  created_at TIMESTAMP DEFAULT NOW()
);

-- ITEMS DE TRANSACCIÓN
CREATE TABLE items_transaccion (
  id SERIAL PRIMARY KEY,
  transaccion_id INTEGER REFERENCES transacciones(id) ON DELETE CASCADE,
  producto_id INTEGER REFERENCES productos(id),
  cantidad INTEGER NOT NULL,
  precio_unitario DECIMAL(10, 2) NOT NULL,
  subtotal DECIMAL(10, 2) NOT NULL,
  created_at TIMESTAMP DEFAULT NOW()
);

-- MOVIMIENTOS DE INVENTARIO
CREATE TABLE movimientos_inventario (
  id SERIAL PRIMARY KEY,
  producto_id INTEGER REFERENCES productos(id),
  tipo VARCHAR(50) NOT NULL CHECK (tipo IN ('entrada', 'salida', 'ajuste')),
  cantidad INTEGER NOT NULL,
  motivo VARCHAR(255),
  user_id UUID REFERENCES users(id),
  created_at TIMESTAMP DEFAULT NOW()
);

-- SERVICIOS DIGITALES
CREATE TABLE servicios_digitales (
  id SERIAL PRIMARY KEY,
  nombre_servicio VARCHAR(150) NOT NULL,
  descripcion TEXT,
  precio_base DECIMAL(10, 2) NOT NULL,
  tiempo_estimado INTEGER,
  activo BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP DEFAULT NOW()
);

-- SOLICITUDES DE SERVICIOS
CREATE TABLE solicitudes_servicios (
  id SERIAL PRIMARY KEY,
  servicio_id INTEGER REFERENCES servicios_digitales(id),
  cliente_nombre VARCHAR(150) NOT NULL,
  cliente_contacto VARCHAR(100),
  descripcion TEXT NOT NULL,
  estado VARCHAR(50) NOT NULL CHECK (estado IN ('pendiente', 'en_proceso', 'completado', 'entregado')),
  precio_final DECIMAL(10, 2),
  fecha_solicitud TIMESTAMP DEFAULT NOW(),
  fecha_entrega TIMESTAMP,
  user_asignado UUID REFERENCES users(id),
  notas TEXT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

-- KPIs DIARIOS
CREATE TABLE kpis_diarios (
  id SERIAL PRIMARY KEY,
  fecha DATE UNIQUE NOT NULL,
  ventas_total DECIMAL(12, 2) DEFAULT 0,
  cantidad_transacciones INTEGER DEFAULT 0,
  ticket_promedio DECIMAL(10, 2) DEFAULT 0,
  margen_bruto_pct DECIMAL(5, 2) DEFAULT 0,
  productos_vendidos_cant INTEGER DEFAULT 0,
  servicios_vendidos_cant INTEGER DEFAULT 0,
  ingresos_productos DECIMAL(12, 2) DEFAULT 0,
  ingresos_servicios DECIMAL(12, 2) DEFAULT 0,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

-- CONFIGURACIÓN
CREATE TABLE configuracion (
  id SERIAL PRIMARY KEY,
  clave VARCHAR(100) UNIQUE NOT NULL,
  valor TEXT NOT NULL,
  tipo VARCHAR(50),
  descripcion TEXT,
  updated_at TIMESTAMP DEFAULT NOW()
);

-- Índices para optimización
CREATE INDEX idx_productos_categoria ON productos(categoria_id);
CREATE INDEX idx_productos_sku ON productos(sku);
CREATE INDEX idx_transacciones_user ON transacciones(user_id);
CREATE INDEX idx_transacciones_fecha ON transacciones(fecha);
CREATE INDEX idx_items_transaccion_id ON items_transaccion(transaccion_id);
CREATE INDEX idx_items_producto_id ON items_transaccion(producto_id);
CREATE INDEX idx_movimientos_producto ON movimientos_inventario(producto_id);
CREATE INDEX idx_solicitudes_estado ON solicitudes_servicios(estado);
CREATE INDEX idx_kpis_fecha ON kpis_diarios(fecha);
```

---

## 6. STACK TECNOLÓGICO

### 6.1 Frontend
| Componente | Tecnología | Justificación |
|-----------|-----------|---------------|
| Framework | React 18+ | Componentes reutilizables, ecosistema maduro |
| Estilos | Tailwind CSS | Rápido, utilidad-first, responsive |
| Gestión de estado | Zustand / Redux | Manejo simplificado de estado global |
| Enrutamiento | React Router v6 | Navegación SPA eficiente |
| Formularios | React Hook Form + Zod | Validación type-safe, sin dependencias pesadas |
| Visualización | Recharts / Chart.js | Gráficos interactivos para KPIs |
| HTTP Client | Axios / Fetch API | Comunicación con backend |
| Build Tool | Vite | Desarrollo rápido, builds optimizados |
| Testing | Vitest + React Testing Library | Pruebas unitarias y componentes |

### 6.2 Backend
| Componente | Tecnología | Justificación |
|-----------|-----------|---------------|
| Runtime | Node.js (18+) | JavaScript full-stack |
| Framework | Express.js | Minimalista, rápido, flexible |
| ORM | Supabase SDK / Prisma | Consultas type-safe a PostgreSQL |
| Autenticación | Supabase Auth | OAuth, JWT, sin complejidad |
| Validación | Zod | Validación schema-first |
| Logging | Winston / Pino | Logs estructurados |
| Task Scheduling | Node-cron | Cálculo de KPIs en background |
| Testing | Jest + Supertest | Pruebas unitarias e integración |
| Environment | dotenv | Configuración segura |

### 6.3 Base de Datos
| Componente | Tecnología | Justificación |
|-----------|-----------|---------------|
| DB Principal | PostgreSQL | Relacional, ACID, escalable |
| Platform | Supabase | Managed PostgreSQL + Auth |
| Backups | Supabase Built-in | Automáticos, georeplicados |
| Almacenamiento | Supabase Storage | Archivos (recibos, documentos) |

### 6.4 Infraestructura & DevOps
| Componente | Tecnología | Justificación |
|-----------|-----------|---------------|
| Hosting Frontend | Vercel / Netlify | Deploys automáticos, CDN global |
| Hosting Backend | Railway / Render | Fácil deploy de Node.js |
| Monitoreo | Sentry | Error tracking en real time |
| Analítica | Mixpanel / Plausible | Comportamiento de usuarios |
| CI/CD | GitHub Actions | Integración continua nativa |
| Version Control | GitHub | Repositorio + colaboración |

### 6.5 Stack Resumido

```json
{
  "frontend": {
    "framework": "React 18 + TypeScript",
    "styling": "Tailwind CSS",
    "state": "Zustand",
    "charts": "Recharts",
    "build": "Vite",
    "deploy": "Vercel"
  },
  "backend": {
    "runtime": "Node.js",
    "framework": "Express.js",
    "orm": "Prisma",
    "auth": "Supabase Auth",
    "validation": "Zod",
    "deploy": "Railway"
  },
  "database": {
    "primary": "PostgreSQL",
    "platform": "Supabase"
  },
  "monitoring": {
    "errors": "Sentry",
    "analytics": "Mixpanel"
  }
}
```

---

## 7. FASES DE DESARROLLO

### 7.1 Cronograma General

```
FASE 1: MVP (Semanas 1-10)        FASE 2: Optimización (Semanas 11-16)
├─ Backend Setup                   ├─ Optimización de rendimiento
├─ Autenticación                   ├─ Reportes avanzados
├─ Inventario                      ├─ Análisis predictivo básico
├─ POS                             ├─ Bulk operations
├─ Servicios                       └─ Capacitación usuarios
├─ Dashboard Básico
└─ Deploy v1.0


FASE 3: Escalabilidad (Semanas 17-24)   FASE 4: Expansión (Semanas 25+)
├─ API robusta para integraciones        ├─ App móvil nativa
├─ Múltiples sucursales                  ├─ Integración marketplace
├─ Facturación fiscal                    ├─ IA avanzada
├─ Integraciones de pago                 ├─ Predicción de demanda
└─ Sincronización offline                └─ Gestión de proveedores
```

### 7.2 Desglose Detallado - FASE 1 (MVP)

#### **SPRINT 1: Fundamentos (Semana 1-2)**

**Backend:**
- [ ] Configuración de proyecto Node.js + Express
- [ ] Setup Supabase (base de datos, auth, storage)
- [ ] Estructura de carpetas (models, controllers, routes, middleware)
- [ ] Variables de entorno y configuración
- [ ] Sistema de logging
- [ ] Middleware de autenticación/autorización

**Frontend:**
- [ ] Setup React + Vite + TypeScript
- [ ] Estructura de componentes (Layout, Pages, Components)
- [ ] Configuración de Tailwind CSS
- [ ] Setup Zustand para estado global
- [ ] Autenticación básica (login/registro)

**BD:**
- [ ] Crear todas las tablas (ver 5.2)
- [ ] Definir índices y constraints
- [ ] Seed data inicial (categorías, servicios)

**Deliverables:**
- Repositorio Git inicializado
- CI/CD básico (GitHub Actions)
- Ambiente de desarrollo local funcionando

#### **SPRINT 2: Autenticación y Usuarios (Semana 3)**

**Backend:**
- [ ] Rutas de autenticación (signup, login, logout)
- [ ] JWT token management
- [ ] Refresh token logic
- [ ] Roles y permisos
- [ ] Rutas protegidas con middleware

**Frontend:**
- [ ] Página de login/registro
- [ ] Persistencia de sesión (localStorage)
- [ ] Protección de rutas privadas
- [ ] Interfaz de usuario y perfil
- [ ] Logout

**Testing:**
- [ ] Tests de autenticación (backend)
- [ ] Tests de componentes auth (frontend)

**Deliverables:**
- Autenticación funcional end-to-end
- Sistema de roles implementado

#### **SPRINT 3: Gestión de Inventario (Semana 4-5)**

**Backend:**
- [ ] CRUD productos (create, read, update, delete)
- [ ] Búsqueda y filtrado de productos
- [ ] Gestión de categorías
- [ ] Movimientos de inventario (entrada/salida/ajuste)
- [ ] Alertas de bajo stock
- [ ] Histórico de cambios

**Frontend:**
- [ ] Tabla de productos con paginación
- [ ] Búsqueda y filtrado en UI
- [ ] Formulario de crear/editar producto
- [ ] Gestión de stock (entry/salida)
- [ ] Vista de alertas de stock bajo
- [ ] Código de barras básico (input)

**Features:**
- [ ] Importación de CSV (opcional MVP)
- [ ] Historial de movimientos

**Deliverables:**
- Módulo de inventario 100% funcional
- Lectura de código de barras básica

#### **SPRINT 4: Punto de Venta (POS) (Semana 6-7)**

**Backend:**
- [ ] Creación de transacciones
- [ ] Items de transacción
- [ ] Cálculo de descuentos (por volumen/cliente)
- [ ] Validación de stock antes de venta
- [ ] Historial de ventas
- [ ] Reportes de ventas por período

**Frontend:**
- [ ] Interfaz POS intuitiva (UI/UX)
- [ ] Selección rápida de productos (búsqueda)
- [ ] Carrito de compra con cantidad
- [ ] Aplicación de descuentos
- [ ] Resumen de venta (subtotal, descuento, total)
- [ ] Confirmación y pago (mock)
- [ ] Generación de recibo (PDF)

**Features:**
- [ ] Descuentos por cantidad
- [ ] Descuentos por cliente frecuente
- [ ] Nota adicional en venta
- [ ] Devoluciones

**Deliverables:**
- POS funcional y usable
- Recibos generados

#### **SPRINT 5: Servicios Digitales (Semana 8)**

**Backend:**
- [ ] CRUD servicios digitales
- [ ] Creación de solicitudes de servicio
- [ ] Estados de solicitud
- [ ] Asignación a usuarios
- [ ] Historial de servicios

**Frontend:**
- [ ] Catálogo de servicios
- [ ] Formulario de solicitud
- [ ] Panel de solicitudes (admin)
- [ ] Actualización de estado
- [ ] Historial de servicios

**Features:**
- [ ] Notificaciones de nueva solicitud
- [ ] Asignación automática (opcional)

**Deliverables:**
- Módulo de servicios digitales funcional

#### **SPRINT 6: Dashboard de KPIs (Semana 9)**

**Backend:**
- [ ] Cálculos de KPIs diarios
- [ ] API de reportes
- [ ] Histórico de KPIs
- [ ] Task scheduler para actualización automática

**Frontend:**
- [ ] Dashboard principal con KPIs clave
  - Ventas del día
  - Cantidad de transacciones
  - Ticket promedio
  - Margen bruto %
  - Top 5 productos
  - Ingresos por línea (Productos vs Servicios)
- [ ] Gráficos interactivos
- [ ] Filtros por período (hoy, semana, mes)

**Features:**
- [ ] Comparativa con período anterior
- [ ] Tendencias visuales

**Deliverables:**
- Dashboard operativo
- KPIs en tiempo real

#### **SPRINT 7: Refine, Testing y Deploy (Semana 10)**

**Backend:**
- [ ] Pruebas completas (unitarias + integración)
- [ ] Documentación API (Swagger/Postman)
- [ ] Validaciones adicionales
- [ ] Seguridad (CORS, Rate limiting, etc.)
- [ ] Performance tuning

**Frontend:**
- [ ] Pruebas de componentes
- [ ] E2E testing (Cypress)
- [ ] Responsividad móvil
- [ ] Optimización de performance
- [ ] Accesibilidad (A11y)

**DevOps:**
- [ ] Setup CI/CD
- [ ] Configuración de ambientes (dev, staging, prod)
- [ ] Deploy a Vercel (frontend)
- [ ] Deploy a Railway (backend)
- [ ] Monitoreo y alertas (Sentry)

**Deliverables:**
- MVP v1.0 en producción
- Documentación completa
- Pruebas automatizadas

### 7.3 Fases 2-4 (Roadmap Futuro)

#### **FASE 2: Optimización (Semanas 11-16)**

```
Sprint 8: Reportes Avanzados
- Reportes por categoría de producto
- Análisis de margen por categoría
- Reportes de servicios (tasa de entrega, tiempo promedio)
- Exportación de datos (Excel, PDF)

Sprint 9: Análisis Predictivo Básico
- Tendencias de ventas
- Alertas de productos con baja rotación
- Sugerencias de reabastecimiento

Sprint 10: Optimización de Performance
- Caché de consultas frecuentes
- Compresión de datos
- Índices de BD adicionales
- CDN para assets estáticos

Sprint 11: Capacitación y Documentación
- Manuales de usuario (PDF)
- Videos de entrenamiento
- Soporte en vivo
```

#### **FASE 3: Escalabilidad (Semanas 17-24)**

```
Sprint 12-15: Múltiples Sucursales
- Soporte para múltiples tiendas
- Consolidación de datos
- Inventario compartido (opcional)
- Reportes por sucursal

Sprint 16-18: Integraciones
- Integración con métodos de pago
- Integración con proveedores
- API pública para terceros
- Sincronización con redes sociales (opcional)

Sprint 19-20: Facturación Fiscal
- Generación de facturas
- Cumplimiento tributario
- Auditoría y trazabilidad
```

#### **FASE 4: Expansión (Semanas 25+)**

```
Sprint 21+: IA y Automatización
- Predicción de demanda (ML)
- Recomendaciones automáticas de precios
- Chatbot de atención al cliente
- Automatización de correos de marketing

Sprint 25+: App Móvil
- App nativa (React Native / Flutter)
- Funcionalidad offline
- Notificaciones push
- Escaneo de código de barras con cámara
```

---

## 8. MÉTRICAS DE ÉXITO

### 8.1 Métricas Técnicas

| Métrica | Target MVP | Target 6 Meses |
|---------|-----------|-----------------|
| Uptime | 99% | 99.9% |
| Latencia API (p95) | <500ms | <200ms |
| Tiempo de carga (Frontend) | <3s | <1.5s |
| Cobertura de tests | 60% | 85%+ |
| Performance Lighthouse | 70+ | 90+ |

### 8.2 Métricas de Negocio

| Métrica | Baseline | Target 3 Meses | Target 6 Meses |
|---------|----------|-----------------|-----------------|
| Tiempo de procesamiento de venta | 3-4 min | <1 min | <30 seg |
| Errores en inventario | 5-10% | <2% | <0.5% |
| Precisión de stock | 80% | 97%+ | 99%+ |
| Adopción de plataforma (usuarios) | 0 | 90%+ | 100% |
| Reducción de tiempo operativo | - | 20% | 40%+ |
| ROI | 0 | +30% | +60%+ |

### 8.3 Métricas de Usabilidad

| Métrica | Target |
|---------|--------|
| SUS Score (System Usability Scale) | 75+ |
| Net Promoter Score (NPS) | 60+ |
| Tasa de error de usuario | <5% |
| Curva de aprendizaje | <4 horas |

---

## 9. PRESUPUESTO Y RECURSOS (INDICATIVO)

### 9.1 Equipo Requerido

```
Desarrollo (MVP):
- 1 Backend Developer (2-3 meses)
- 1 Frontend Developer (2-3 meses)
- 1 DevOps/QA Engineer (1.5 meses)
- 1 Product Manager (3 meses)
- Total: 7-9 meses/persona

Mantenimiento Post-MVP:
- 1 Backend Developer (part-time)
- 1 Frontend Developer (part-time)
- 1 DevOps Engineer (part-time)
```

### 9.2 Costos Estimados (Cloud/Servicios)

```
Desarrollo (Freelance/Agencia):
- Backend + Frontend + DevOps: $8,000 - $15,000 USD
- Testing y QA: $1,000 - $2,000 USD

Cloud/SaaS Mensuales:
- Supabase (Pro): $25 USD
- Vercel (Pro): $20 USD
- Railway (compute): $5-50 USD (según uso)
- Sentry (Pro): $29 USD
- SendGrid/Email: $20 USD
- Total Mensual: ~$120-150 USD

Total Fase 1 (MVP): ~$10,000 - $18,000 USD
Costo Operativo Anual: ~$2,000 USD
```

---

## 10. RIESGOS Y MITIGACIÓN

| Riesgo | Probabilidad | Impacto | Mitigación |
|--------|-------------|--------|-----------|
| Retrasos en desarrollo | Media | Alto | Sprints cortos, daily standups |
| Pérdida de datos | Baja | Crítico | Backups automáticos, disaster recovery |
| Baja adopción de usuarios | Media | Alto | Capacitación, UX design iterativo |
| Seguridad (breach) | Baja | Crítico | Auditorías, encryption, security training |
| Performance en escala | Baja | Medio | Load testing, índices de BD, caching |
| Cambios de requerimientos | Alta | Medio | Metodología ágil, feedback frecuente |

---

## 11. PRÓXIMOS PASOS

### 11.1 Inmediato (Esta Semana)

- [ ] **Validar arquitectura** con el equipo técnico
- [ ] **Confirmar stack** y herramientas
- [ ] **Crear repositorio GitHub** con estructura inicial
- [ ] **Setup de Supabase** (base de datos, auth)
- [ ] **Definir sprints** con hitos claros

### 11.2 Semana 1

- [ ] Kick-off del proyecto
- [ ] Configuración local de ambiente
- [ ] First commit del backend + frontend
- [ ] Setup CI/CD pipeline

### 11.3 Semana 2-3

- [ ] Autenticación implementada
- [ ] Primeros CRUD funcionales
- [ ] Primeras pantallas en frontend

---

## 12. REFERENCIAS Y RECURSOS

### Documentación de Tecnologías
- [React Documentation](https://react.dev)
- [Express.js Guide](https://expressjs.com)
- [Supabase Documentation](https://supabase.com/docs)
- [Tailwind CSS](https://tailwindcss.com)

### Frameworks de Metodología
- Agile Scrum (2 semanas por sprint)
- Kanban para gestión de tareas
- Code Review en cada PR

### Herramientas Recomendadas
- GitHub para versionado
- Slack para comunicación
- Figma para diseño
- Notion para documentación
- Linear o GitHub Projects para tickets

---

**Autor:** Arquitecto de Software  
**Última actualización:** Junio 2026  
**Estado:** Documento vivo - Sujeto a cambios según validación de negocio
