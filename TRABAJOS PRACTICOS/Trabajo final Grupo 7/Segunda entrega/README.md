# Segunda entrega - Grupo 7

Sistema de Gestión de Turnos para una Clínica. Versión Java por consola.

## Contenido

- `Codigo Java`: 14 archivos fuente, incluido Main, para ejecutar el menú por consola.
- `TP_Gestion_Turnos_Clinica_Segunda_Entrega.docx`: trabajo actualizado, diagramas de clases y roadmap de tres entregas.

## Ejecutar

Con el JDK instalado, abrir una terminal dentro de `Codigo Java`:

```text
javac -encoding UTF-8 *.java
java Main
```

Para una demostración automática:

```text
java Main demo
```

Permite registrar pacientes y médicos, cargar y consultar turnos, cancelarlos y marcarlos como atendidos. Valida fechas, horarios cada 30 minutos y turnos superpuestos.

Los datos se mantienen en memoria y se pierden al cerrar el programa. El recordatorio de correo se simula en la consola; no envía mensajes reales.

## Roadmap

1. Propuesta y modelo: primera entrega.
2. Java por consola: esta entrega.
3. Aplicación completa: interfaz Swing, persistencia, conexiones y entrega final.

La interfaz gráfica no forma parte de los fuentes de esta entrega. El documento distingue lo implementado de las funciones previstas.

## Verificación

Compilado con JDK 21. Se ejecutaron la demostración y 26 comprobaciones sobre carga, validaciones, estados y disponibilidad.
