### ❌ Pregunta 1: `NullPointerException` al acceder a `findViewById`
#### 🔹 **Descripción:**
Al ejecutar la aplicación, se produce un `NullPointerException` al intentar acceder a un `View` con `findViewById()`.
#### 🔹 **Preguntas:**
- ¿Por qué ocurre este error?
- ¿En qué situaciones es más probable que suceda?
- ¿Cómo se puede corregir?

#### 🔹 **Respuestas:**
- Ocurre cuando se esta asignando un valor a una variable y su fuente es un objeto o valor nulo o sin valor.
- Es mas probable que suceda cuando no se tiene validadores y manejos de excepciones adecuados, por ejemplo un operador elvis o un let y damos por hecho que el objeto no es nulo y no asignamos un valor por defecto.
- Se puede corregir agregando validadores y manejos de excepciones adecuados, por ejemplo un operador elvis o un let,  en caso que manejemos datos de un data class, en este caso usamos vistas,
entonces se debe validar que la vista se cargue antes de acceder al componente para referenciarlo con `findViewById() y darle un valor a una variable


### ❌ Pregunta 2: `IllegalStateException` al usar `ViewModel`
#### 🔹 **Descripción:**
Al inicializar un `ViewModel`, se genera un `IllegalStateException` indicando que no se puede crear una instancia en el contexto actual.
#### 🔹 **Preguntas:**
- ¿Cuál es la causa de este error?
- ¿Por qué es importante el ciclo de vida en la inicialización del `ViewModel`?
- ¿Cómo se debe instanciar correctamente un `ViewModel` en una `Activity` o `Fragment`?

#### 🔹 **Respuestas:**
- Se genera cuando estamos intentando crear una instancion de un objeto que esta fuera del contexto actaul del ciclo de vida de la vista.
- Porque es el momento cuando se cargan los componentes de UI y procesos en segundo plano empiezan a ejecutarse y validamos nulabilidad de los datos.
- Se debe instanciar un ViewModel utilizando el ViewModelProvider dentro del activity necesario 

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

#### 🔹 **Respuestas:**
- Una posible causa puede ser cuando se quiere llamar una actividad y no existe, o existe y no se ha declarado en el manifest.
- Debbugeando todo el ciclo de vida de la actividad, asegurando que la actividad a la que se quiere llamar exista y este declarada en el manifest, y que el intent este correctamente configurado.
---

### ❌ Pregunta 5: `java.lang.OutOfMemoryError` al cargar imágenes grandes
#### 🔹 **Descripción:**
La aplicación se cierra inesperadamente con un `java.lang.OutOfMemoryError` al cargar imágenes de gran tamaño en un `ImageView`.
#### 🔹 **Preguntas:**
- ¿Por qué se puede producir este error al manejar imágenes?
- ¿Qué estrategias puedes aplicar para evitarlo?

#### 🔹 **Respuestas:**
- Se produce cuando el procesamiento de la app llega al limite de momeria del dispositivo, por ejemplo al cargar una imagen de gran tamaño en un ImageView.
- Se pueden gestionar validadores de peso de imagen en un Picker con un tamaño máximo por defecto o comprimir la imagen con un Compress

---

### ❌ Pregunta 6: Ciclo de vida de una Actividad
#### 🔹 **Preguntas:**
- Describe los estados principales del ciclo de vida de una `Activity` (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`).
- ¿En qué situación se llamaría a `onRestart`?
- ¿Qué métodos se invocan cuando la pantalla rota? ¿Cómo puedes preservar el estado de la UI durante este evento?

#### 🔹 **Respuestas:**
- OnCreate: Es cuando se carga la vista y se inicializan los componentes de UI por primera vez.
- OnStart: Es cuando la vista está inflada y visible para el usuario.
- OnResume: Es cuando la vista vuelve a estar en primer plano pero no fué cerrada previamente y se dejó en segundo plano.
- OnPause: Es cuando la vista se minimiza y queda en segundo plano.
- OnStop: Es cuando la vista se cierra y ya no es visible para el usuario.
- OnDestroy: Es cuando la vista se destruye y se libera de memoria, ocurre cuando se cierra la app o se cambia de actividad.

- OnRestart: Desconozco este momento del ciclo de vida, pero deduzco que es cuando la vista se vuelve a iniciar con procesos en segundo plano y la vista como tal no se ha destruido o pausado

- En XML puedo usar un onSaveInstance para mantener la data ante los cambios de la UI, en JetpackCompose usaria un byRemeber para mantener la data y se refrezca al estado de la UI
---

### ❌ Pregunta 7: Tipos de datos, diferencia entre val y var
#### 🔹 **Preguntas:**
- ¿Cuál es la diferencia fundamental entre `val` y `var` en Kotlin?
- Proporciona un ejemplo de cuándo usarías `val` y cuándo usarías `var`.
- ¿Qué significa que `val` es inmutable? ¿Se puede modificar el objeto al que hace referencia una variable `val`? Explícalo con un ejemplo.

#### 🔹 **Respuestas:**
- La diferencia es la mutabilidad, val es inmutable y var es mutable.
- Data Class Persona(
    val nombre: String,
    var edad: Int ) una persona no puede cambuar su nombre, pero si puede cambiar su edad.
- val significa que es inmutable porque protege la integridad de la variable cuando sabemos que no debe o no puede cambiar,
como el ejemplo anterior, una persona no puede cambiar su nombre, pero si puede cambiar su edad, por eso val edad
- No se puede modificar una variable de estado val en kotlin, pero si se puede modificar el objeto al que hace referencia una variable val, ejemplo:
 data class Cumpleaños(
  val nombre: String,
  val fechaNacimiento: DateTime,
  var edadCumpleAnos: Int = fechaNacimiento.daysUntil(LocalDate.current())) una persona no puede cambiar su fecha de cumpleaños, pero si puede cambiar su edad en este caso modificamos su edad con un nuevo valor con una varible tipo val.