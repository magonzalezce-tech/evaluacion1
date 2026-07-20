# Evaluación 1 - Sistema de Gestión en Java

Este proyecto consiste en una aplicación desarrollada en **Java** orientada a la gestión de datos, aplicando conceptos de Programación Orientada a Objetos (POO), arquitectura en capas, manejo de excepciones personalizadas y persistencia de archivos.

---

## 🛠️ Tecnologías y Herramientas

* **Lenguaje:** Java (JDK 17 o superior)
* **Gestor de Dependencias:** Maven (Manejado mediante `pom.xml`)
* **IDE Recomendado:** IntelliJ IDEA / Eclipse / NetBeans

---

## 📂 Estructura del Proyecto

El proyecto sigue una arquitectura limpia dividida en capas para separar las responsabilidades de manera eficiente:

* **`src/main/java`**: Contiene el código fuente principal organizado en los siguientes paquetes:
  * `model`: Clases entidad u objetos de negocio que representan el dominio del sistema.
  * `servicio` / `Servicios`: Capa de lógica de negocio que procesa las reglas del sistema.
  * `ui`: Interfaz de usuario (Consola o Gráfica) encargada de interactuar con el usuario.
  * `data`: Gestión de persistencia, lectura y escritura de datos (Archivos locales).
  * `exception`: Clases de excepciones personalizadas para el control robusto de errores.
  * `util`: Clases de utilidad generales (validadores, formateadores, etc.).
* **`pom.xml`**: Archivo de configuración de Maven para la gestión de librerías y dependencias.

---

## 🚀 Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:
1. **Java Development Kit (JDK)** versión 17 o superior.
2. **Apache Maven** (opcional, si deseas compilar por línea de comandos).

---

## 💻 Instalación y Ejecución

Sigue estos pasos para clonar y ejecutar el proyecto localmente:

### 1. Clonar el repositorio
```bash
git clone https://github.com/magonzalezce-tech/evaluacion1.git
cd evaluacion1
```

### 2. Compilar con Maven
Si utilizas la terminal, compila el proyecto para descargar las dependencias necesarias:
```bash
mvn clean install
```

### 3. Ejecución
* **Desde tu IDE:** Busca la clase principal que contiene el método `main` (usualmente ubicada en el paquete raíz de código fuente o dentro de `ui`) y ejecútala.
* **Desde la consola (si está empaquetado):**
```bash
java -jar target/evaluacion1-1.0-SNAPSHOT.jar
```

---

## ⚙️ Características Principales

* **Arquitectura Modular:** Separación estricta entre la interfaz de usuario, la lógica de negocio y el almacenamiento de datos.
* **Persistencia de Datos:** Carga y guardado automatizado de información mediante el manejo de archivos locales.
* **Control de Errores Avanzado:** Excepciones a medida para capturar fallos operacionales de manera limpia sin interrumpir el flujo del programa.

---

## 📝 Licencia

Este proyecto se encuentra bajo la licencia estándar de uso educativo/evaluativo.
