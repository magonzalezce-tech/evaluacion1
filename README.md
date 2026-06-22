# Sistema de Gestión de Personas - Llanquihue Tour 🌲✈️

Este proyecto consiste en el diseño e implementación de un modelo de clases robusto y estructurado en Java para la empresa **Llanquihue Tour**. El sistema aborda y resuelve los problemas críticos de información duplicada, gestión manual informal y falta de diferenciación de roles mediante la aplicación rigurosa de los principios de la Programación Orientada a Objetos (POO).

## 🚀 Características Principales

- **Arquitectura Limpia:** Organización desacoplada mediante el uso estricto de paquetes (`model` y `app`).
- **Encapsulamiento Avanzado:** Atributos privados con acceso controlado mediante métodos *getters* y *setters*.
- **Validación Automatizada de Datos:** Filtros nativos mediante expresiones regulares (Regex) para la purificación de RUT chilenos y correos electrónicos desde el constructor.
- **Relaciones de Objetos Eficientes:** 
  - **Composición:** Asociación fuerte entre la entidad `Persona` y su `Direccion`.
  - **Herencia:** Especialización de roles claros para `Empleado` y `Proveedor` extendiendo la clase base.
- **Polimorfismo y Colecciones Dinámicas:** Centralización del inventario de personas en un único `ArrayList<Persona>`, permitiendo el filtrado y clasificación en tiempo de ejecución.

---

## 📂 Estructura del Proyecto

El código se encuentra organizado bajo el estándar de proyectos Java en las siguientes carpetas:

```text
src/
├── app/
│   └── Main.java          # Clase principal de ejecución y pruebas de carga.
└── model/
    ├── Direccion.java     # Componente de composición para ubicaciones.
    ├── Persona.java       # Clase base general con lógica de validación.
    ├── Empleado.java      # Especialización para colaboradores internos.
    └── Proveedor.java     # Especialización para socios comerciales externos.
│
└──servicio/
   ├──Gestion.java          # Lógica de negocio y persistencia
```

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (Compatible con JDK 11 o superior)
- **IDE Recomendado:** IntelliJ IDEA / Eclipse / VS Code
- **Paradigma:** Programación Orientada a Objetos (POO)

---

## 💻 Instrucciones de Instalación y Ejecución

### Prerrequisitos
Asegúrate de tener instalado el **Java Development Kit (JDK)** en tu sistema. Puedes verificarlo ejecutando:
```bash
java -version
```

### Clonar y Ejecutar de Forma Local

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com
   cd llanquihue-tour-gestion
   ```

2. **Compilar el proyecto (desde la carpeta `src`):**
   ```bash
   javac app/Main.java model/*.java
   ```

3. **Ejecutar la aplicación:**
   ```bash
   java app.Main
   ```

---

## 📊 Demostración de Salida en Consola

Al ejecutar el sistema, se simulará la carga centralizada de datos y la activación de los filtros automáticos de roles, además de demostrar la detección de datos inválidos:

```text
✅ Inicialización completada. Registros cargados: 3

--- MENÚ DE CONTROL ---
1. Mostrar todos los registros
2. Buscar registro por nombre
3. Salir del sistema
Seleccione una opción: 1

--- LISTADO GENERAL ---
RUT: 11.111.111-1 | Nombre: María Ortega | Correo: maria@email.com | Dirección: [Av. Vicente Pérez Rosales N° 450, Puerto Varas]
RUT: 22.222.222-2 | Nombre: Carlos Pérez | Correo: carlos@llanquihuetour.cl | Dirección: [Calle San Pedro N° 1025, Llanquihue] | Rol: Guía de Turismo | Sueldo Base: $850000.0
RUT: 76.543.210-K | Nombre: Transporte Marítimo Lago | Correo: contacto@lago.cl | Dirección: [Costanera N° 101, Frutillar] | Servicio: Transporte | Contacto: Rupert Allen
```

---

## 📈 Próximos Pasos (Roadmap)

- [ ] Implementar un menú interactivo en consola utilizando la clase `Scanner`.
- [ ] Incorporar el manejo de excepciones personalizadas (`Exception`) para robustecer las alertas de datos inválidos.
- [ ] Diseñar el módulo independiente para la gestión y asignación de "Paquetes Turísticos".
- [ ] Conectar la capa del dominio (`model`) a una base de datos relacional para persistencia de datos.
