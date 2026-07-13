# 🌲 Llanquihue Tour — Sistema de Gestión de Personas ✈️

![Java](https://shields.io)
![Paradigma](https://shields.io)
![Entorno](https://shields.io)

Solución en **Java** para la gestión de clientes, empleados y proveedores de "Llanquihue Tour", enfocada en estructurar datos y mejorar la organización mediante Programación Orientada a Objetos.

---

## 🎯 Solución Técnica
* 📉 **Gestión de Datos:** Uso de colecciones para eliminar duplicidad.
* 🛡️ **Validaciones:** Lógica para limpieza de datos (RUT/Correo) usando expresiones regulares.
* 👤 **Roles:** Jerarquización de personas, empleados y proveedores.

---

## 🏗️ Implementación POO
El sistema aplica los pilares de la programación orientada a objetos:
1.  **Encapsulamiento:** Métodos públicos para acceder a atributos privados.
2.  **Composición:** Integración de la clase `Direccion` dentro de `Persona`.
3.  **Herencia:** Especialización de `Persona` para `Empleado` y `Proveedor`.
4.  **Polimorfismo:** Manejo de datos mediante `ArrayList<Persona>`.

---

## 📂 Estructura
```text
src/
├── app/         # Punto de entrada (Main.java)
├── model/       # Clases: Persona, Direccion, Empleado, Proveedor
└── servicio/    # Lógica de negocio (Gestion.java)
```

---

## 🛠️ Requisitos e Instalación
*   **JDK 11+**
1.  `git clone https://github.com/magonzalezce-tech/evaluacion1.git`
2.  `cd evaluacion1/src`
3.  `javac app/Main.java model/*.java servicio/*.java`
4.  `java app.Main`

---

## 📊 Vista Previa
```text
RUT: 11.111.111-1 | Nombre: María Ortega | ...
RUT: 22.222.222-2 | Nombre: Carlos Pérez | Rol: Guía | ...
```

---

## 📈 Roadmap
*   [ ] 🎛️ Migrar a `Scanner` para interacción dinámica.
*   [ ] ⚠️ Implementar excepciones personalizadas.
*   [ ] 🗃️ Integrar módulo de Paquetes Turísticos.
*   [ ] 💾 Migración a base de datos SQL.

- [ ] Implementar un menú interactivo en consola utilizando la clase `Scanner`.
- [ ] Incorporar el manejo de excepciones personalizadas (`Exception`) para robustecer las alertas de datos inválidos.
- [ ] Diseñar el módulo independiente para la gestión y asignación de "Paquetes Turísticos".
- [ ] Conectar la capa del dominio (`model`) a una base de datos relacional para persistencia de datos.
