# 🔍 01_Debugging – Corrección de Errores

## Contexto

La aplicación que se encuentra en este módulo tiene como objetivo mostrar un texto en pantalla que se actualiza en respuesta a ciertos eventos. Sin embargo, la implementación actual contiene varios errores críticos que impiden que funcione correctamente y, además, causan problemas de rendimiento y memoria.

## Tu Misión

Tu tarea es actuar como un desarrollador encargado de revisar y corregir este código. Debes:

1.  **Identificar y corregir los errores:** La aplicación crashea al iniciarse y tiene otros problemas ocultos. Encuentra todos los fallos.
2.  **Explicar tus cambios:** No basta con corregir. Debes explicar **por qué** el código original estaba mal y **cómo** tu solución arregla el problema. Puedes añadir comentarios en el código (`// FIX: ...`) o crear un archivo `correcciones.md` para documentar tus hallazgos.
3.  **Garantizar la funcionalidad:** Al final, la aplicación debe iniciarse sin errores, mostrar el texto del `ViewModel` y actualizarse correctamente sin fugas de memoria ni crasheos.

## Pistas

Los errores están relacionados con las siguientes áreas:
*   El ciclo de vida de la `Activity` y la inicialización de las vistas.
*   La comunicación entre la `Activity` y el `ViewModel`.
*   La gestión de hilos (concurrencia).
*   El manejo de `BroadcastReceivers` y posibles fugas de memoria.

**Objetivo:** Evaluar tu capacidad para depurar, analizar y aplicar soluciones robustas en una aplicación Android.