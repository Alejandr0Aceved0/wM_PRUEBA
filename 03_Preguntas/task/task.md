# 🧠 Diagnóstico y Corrección de Errores en Android
A continuación, se presentan errores comunes en el desarrollo de aplicaciones Android.  
Para cada pregunta, analiza el mensaje de error, explica por qué ocurre y cómo podrías corregirlo.

El objetivo de esta prueba es evaluar tu capacidad para:

✔ Identificar correctamente la causa del error.   
✔ Explicar por qué ocurre.   
✔ Proponer una solución efectiva y aplicable en un entorno real.   

---

## ❌ Pregunta 1: `NullPointerException` al acceder a `findViewById`
### 🔹 **Descripción:**
Al ejecutar la aplicación, se produce un `NullPointerException` al intentar acceder a un `View` con `findViewById()`.

### 🔹 **Preguntas:**
- ¿Por qué ocurre este error?
- ¿En qué situaciones es más probable que suceda?
- ¿Cómo se puede corregir?

---

## ❌ Pregunta 2: `IllegalStateException` al usar `ViewModel`
### 🔹 **Descripción:**
Al inicializar un `ViewModel`, se genera un `IllegalStateException` indicando que no se puede crear una instancia en el contexto actual.

### 🔹 **Preguntas:**
- ¿Cuál es la causa de este error?
- ¿Por qué es importante el ciclo de vida en la inicialización del `ViewModel`?
- ¿Cómo se debe instanciar correctamente un `ViewModel` en una `Activity` o `Fragment`?

---

## ❌ Pregunta 3: `NetworkOnMainThreadException` al hacer una petición HTTP
### 🔹 **Descripción:**
Se genera un `NetworkOnMainThreadException` cuando la aplicación intenta realizar una petición HTTP en el hilo principal.

### 🔹 **Preguntas:**
- ¿Por qué Android bloquea las operaciones de red en el hilo principal?
- ¿Qué estrategias existen para ejecutar operaciones de red correctamente?
- ¿Cómo podrías corregir este problema en una aplicación real?

---

## ❌ Pregunta 4: `ActivityNotFoundException` al iniciar una nueva actividad
### 🔹 **Descripción:**
Al intentar abrir una nueva `Activity` mediante un `Intent`, se produce un `ActivityNotFoundException`.

### 🔹 **Preguntas:**
- ¿Cuáles son las posibles razones de este error?
- ¿Qué pasos adicionales puedes seguir para evitar este problema en tiempo de ejecución?

---

## ❌ Pregunta 5: `java.lang.OutOfMemoryError` al cargar imágenes grandes
### 🔹 **Descripción:**
La aplicación se cierra inesperadamente con un `java.lang.OutOfMemoryError` al cargar imágenes de gran tamaño en un `ImageView`.

### 🔹 **Preguntas:**
- ¿Por qué se puede producir este error al manejar imágenes?
- ¿Qué estrategias puedes aplicar para evitarlo?
