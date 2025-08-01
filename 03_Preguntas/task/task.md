# 🧠 Diagnóstico y Corrección de Errores en Android

## 📝 Instrucciones

A continuación, se presentan varias preguntas sobre errores comunes en el desarrollo de aplicaciones Android. Tu objetivo es demostrar tu capacidad para diagnosticar y resolver problemas.

**Para completar esta tarea:**

1.  Crea un nuevo archivo llamado `respuestas.md` dentro del directorio actual (`03_Preguntas/task/`).
2.  En ese archivo, responde a cada una de las siguientes preguntas de la forma más clara y detallada posible.
3.  Para cada pregunta, explica la causa del error, el contexto en el que suele aparecer y cómo lo solucionarías en un proyecto real.

Una vez que hayas respondido a todas las preguntas, asegúrate de que el archivo `respuestas.md` esté guardado antes de finalizar la evaluación.

---

## ❓ Preguntas

### ❌ Pregunta 1: `NullPointerException` al acceder a `findViewById`
#### 🔹 **Descripción:**
Al ejecutar la aplicación, se produce un `NullPointerException` al intentar acceder a un `View` con `findViewById()`.
#### 🔹 **Preguntas:**
- ¿Por qué ocurre este error?
- ¿En qué situaciones es más probable que suceda?
- ¿Cómo se puede corregir?

---

### ❌ Pregunta 2: `IllegalStateException` al usar `ViewModel`
#### 🔹 **Descripción:**
Al inicializar un `ViewModel`, se genera un `IllegalStateException` indicando que no se puede crear una instancia en el contexto actual.
#### 🔹 **Preguntas:**
- ¿Cuál es la causa de este error?
- ¿Por qué es importante el ciclo de vida en la inicialización del `ViewModel`?
- ¿Cómo se debe instanciar correctamente un `ViewModel` en una `Activity` o `Fragment`?

---

### ❌ Pregunta 3: `NetworkOnMainThreadException` al hacer una petición HTTP
#### 🔹 **Descripción:**
Se genera un `NetworkOnMainThreadException` cuando la aplicación intenta realizar una petición HTTP en el hilo principal.
#### 🔹 **Preguntas:**
- ¿Por qué Android bloquea las operaciones de red en el hilo principal?
- ¿Qué estrategias existen para ejecutar operaciones de red correctamente?
- ¿Cómo podrías corregir este problema en una aplicación real?

---

### ❌ Pregunta 4: `ActivityNotFoundException` al iniciar una nueva actividad
#### 🔹 **Descripción:**
Al intentar abrir una nueva `Activity` mediante un `Intent`, se produce un `ActivityNotFoundException`.
#### 🔹 **Preguntas:**
- ¿Cuáles son las posibles razones de este error?
- ¿Qué pasos adicionales puedes seguir para evitar este problema en tiempo de ejecución?

---

### ❌ Pregunta 5: `java.lang.OutOfMemoryError` al cargar imágenes grandes
#### 🔹 **Descripción:**
La aplicación se cierra inesperadamente con un `java.lang.OutOfMemoryError` al cargar imágenes de gran tamaño en un `ImageView`.
#### 🔹 **Preguntas:**
- ¿Por qué se puede producir este error al manejar imágenes?
- ¿Qué estrategias puedes aplicar para evitarlo?

---

### ❌ Pregunta 6: Ciclo de vida de una Actividad
#### 🔹 **Preguntas:**
- Describe los estados principales del ciclo de vida de una `Activity` (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`).
- ¿En qué situación se llamaría a `onRestart`?
- ¿Qué métodos se invocan cuando la pantalla rota? ¿Cómo puedes preservar el estado de la UI durante este evento?

---

### ❌ Pregunta 7: Tipos de datos, diferencia entre val y var
#### 🔹 **Preguntas:**
- ¿Cuál es la diferencia fundamental entre `val` y `var` en Kotlin?
- Proporciona un ejemplo de cuándo usarías `val` y cuándo usarías `var`.
- ¿Qué significa que `val` es inmutable? ¿Se puede modificar el objeto al que hace referencia una variable `val`? Explícalo con un ejemplo.