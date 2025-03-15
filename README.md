
# CLASES EXTRAS YOUTUBE (MÁSTER) `ANTONIO LEIVA` (`Videos - Antonio Leiva`)

# ____________________ 1. CARPETA `Android Kotlin` ____________________
Proyecto `1-pruebas-intro`

## INDICE
## 1. SUBCARPETA `Introducción`
* 1. Video: `Bienvenida Kotlin`
* 2. Video: `Qué es Kotlin`
* 3. Video: `Primer proyecto`

## 2. SUBCARPETA `Conceptos básicos`
[ `MainActivity.kt` ]
* 1. Video: `Funciones`
* 2. Video: `Variables`
* 3. Video: `String Templates`

## 3. SUBCARPETA `Clases, properties e interfaces`
* 1. Video: `Clases` [ `Clases.kt` ]
* 2. Video: `Properties` [ `MediaAdapter.kt`, `MediaItem.kt`, `MediaProvider.kt` ]
* 3. Video: `Interfaces`
### 3.1. `Interfaz` para simplificar los `Logs` [ `Logger.kt` ]
* 4. Video: `Data Classes` [ `DataClasses.kt` ]
### 3.2. ¿Cuándo usar `Data Classes` en lugar de `Clases Normales`?

## 4. SUBCARPETA `Funciones de extensión`
* 1. Video: `Funciones de extensión` [ `Extensions.kt` ]
* 2. Video: `Tipos de Reified`
* 3. Video: `Modificador inline`

## 5. SUBCARPETA `Descubriendo la magia de Kotlin`
* 1. Video: `Enumerados`
* 2. Video: `Control de flujo` [ `When.kt`, `res/drawable/new vector asset` ]
* 3. Video: `Kotlin android extensions` (DEPRECADO)
* 4. Video: `ViewBinding`
* 5. Video: `Funciones de Scope` [ `Scopes.kt` ]

## 6. SUBCARPETA `Lambdas`
* 1. Video: `Qué es una lambda` [ `Lambda.kt` ]
* 2. Video: `Lambdas con receivers`
### 6.1. ¿`Swift` utiliza `lambdas`?

## 7. SUBCARPETA `Dando vida a nuestra app`
* 1. Video: `Delegación de propiedades`
### 7.1. ¿Qué es `inflar` una `vista`?
* 2. Video: `Colecciones` [ `Colecciones.kt` ]
* 3. Video: `Rangos`
* 4. Video: `Funciones infix` [ `Infix.kt`]
* 5. Video. `Objects` [ `Objeto.kt` ]

## 8. SUBCARPETA `Android KTX y Corrutinas`
* 1. Video. `Android KTX`
### 8.1. ¿Qué es un DSL?
* 2. Video. `Properties de extensión y Sobrecarga de Operadores` [ `PropertiesExt.kt` ]
* 3. Video. `Corrutinas` [ `Corrutinas.kt` ]
* 4. Video. `Coroutine Scope`
* 5. Video. `User Lifecycle Scope`

## 9. SUBCARPETA `Creando la actividad de detalle`
* 1. Video. `Nulidad y tipos nullables` [ `Nulos.kt` ]
* 2. Video. `Clases selladas`. [`ClaseSelladas.mk`, `Filter.mk`]
* 3. Video. `Type Alias`

## 10. SUBCARPETA - VIDEO `Compatibilidad con Java`

## 11. SUBCARPETA `Android Arquitecturas`
* 1. Video. `MVP`
* 2. Video. `MVVM`
* 3. Video. `Testing`
* 4. Video. `Koin`

## 12. SUBCARPETA - VIDEO `Kotlin DSL`

## ESQUELETO DE LA APP
* Carpeta `data`:
    - Fichero `Filter.kt`: es un `sealed class` que representa los estados del filtrado posible.
    - Fichero `MediaItem.kt`: es un `data class` que representa el formato de un item
    - Fichero `MediaProvider.kt`: es un `objeto` que devuelve todos los items en la app.

* Carpeta `ui`:
    - Fichero `Logger.kt`: es una `interface` donde se definen los casos posibles de lineas de log.
    - Fichero `extensions.kt`: son muchas `fun`, son extensiones de otros componentes (vistas, funciones...). Tambien se encuentra un `inline fun`.

    + Subcarpeta `main`:
        - Fichero `MainActivity.kt`: es un `class` para la pantalla principal (componente Activity).
        - Fichero `MediaAdapter.kt`: es un `class`, es el puente entre los datos (MediaItem) y la interfaz (RecyclerView).

    + Subcarpeta `detail`:
        - Fichero `DetailActivity.kt`: es un `class` para la pantalla secundaria (componente Activity).

+ Subcarpeta de recursos `layout`:
    - Fichero `activity_main.xml`: vista principal (listado)
    - Fichero `view_media_item.xml`: vista de un elemento del listado
    - Fichero `activity_detail.xml`: vista de un imagen de un elemento del listado

## 1. SUBCARPETA `Introducción`
Bienvenida al curso.

* 1. Video: `Bienvenida Kotlin`
Presentación del curso y índice de todo lo que se va a ver.

* 2. Video: `Qué es Kotlin`
Organización del curso donde vamos a crear una aplicación.

### 2.1. ¿Qué es Kotlin?
- Creado por JetBrains.
- Se ejecuta en la JVM.
- Tipado estático, en todo momento se sabe de que tipo es cada variable.
- Orientado a objetos y funcional.
- Gratis y open source.
- Filosofia: pragmático (reducir al máximo la cantidad de boilerplate), conciso, seguro, interoperable.

* 3. Video: `Primer proyecto`
Crear aplicación en Java y transformarla a Kotlin. Creación de proyecto `1-pruebas-intro`.

## 2. SUBCARPETA `Conceptos básicos`
Conceptos básicos que son las funciones, variables y string templete (escribir en un 'print' info con un string).

* 1. Video: `Funciones`
Creamo un nuevo fichero `MainActivity.kt`.

* 2. Video: `Variables`
Añaden en el fichero `MainActivity.kt`.

* 3. Video: `String Templates`
Añaden en el fichero `MainActivity.kt`.

## 3. SUBCARPETA `Clases, properties e interfaces`

* 1. Video: `Clases`
Creamo un nuevo fichero `Clases.kt`.

Probamos los tipos de clase:
- `Clase normal` que permite heredar pero no ser heredada
- `Clase con 'open'` que permite heredar y ser heredada
- `Clase con 'abstract'` que no se puede ser instanciar
- `Clase con varios constructores` que puede tener diferentes intancias.

* 2. Video: `Properties`
Es el equivalente a un `campo público` con un `getter` y `setter`.

Añadimos en el fichero `Clases.kt` ejemplos de properties.
En el `activity_main.xml` añado un `RecyclerView`.
Creo una vista con el contenido de como van a ser cada elemento de un listado en `view_media_item.xml`.
Añado dependencias para usar el listado `RecyclerView` y para poder cargar imagenes `Glide`.
Añado en `AndroidManifest.xml` el permiso para poder obtener información de internet.
Creo la clase `MediaAdapter.kt` que es el puente entre los datos (items) y la interfaz (RecyclerView).
Creo la clase `MediaItem.kt` que representa un item con un título (title) y una imagen (url).
Creo el fichero `MediaProvider.kt` que genera la lista de datos.
Edito en el `MainActivity.kt` que se llame al layout `RecyclerView` creando una instancia de `MediaAdapter` con la lista `MediaProvider()`.

* 3. Video: `Interfaces`
Las interfaces pueden tener dentro código pero no estados (properties) pero si métodos, funciones, etc para usarlo en distintas clases.

### 3.1. `Interfaz` para simplificar los `Logs`
Creamos la clase `Logger.kt` donde creamos una interfaz con el `tag` prefijado y con `una función` para cada tipo de log los cuales solo le tendremos que pasar por parámetro el error.

Luego en cada clase que queramos (en mi caso en `MainActivity.kt`) se extiende la interfaz y ya se puede llamar a todas las funciones de la interfaz.

* 4. Video: `Data Classes`
Creamos un nuevo fichero `DataClasses.kt`

Una `data class` es un tipo especial de clase diseñada para almacenar datos de manera concisa y eficiente. Se usa cuando el propósito principal de la clase es contener datos en lugar de definir comportamientos complejos.

Una data class es similar a una clase normal, pero Kotlin genera automáticamente varias funciones útiles para trabajar con los datos, como:
• `equals()` → Compara si dos objetos tienen los mismos valores.
• `hashCode()` → Genera un código hash basado en los valores.
• `toString()` → Representación en cadena de los datos.
• `copy()` → Crea una copia del objeto con modificaciones opcionales.
• `componentN()` → Permite la desestructuración de objetos.

### 3.2. ¿Cuándo usar `Data Classes` en lugar de `Clases Normales`?
Usa `data class` cuando:
✅ La clase se usa principalmente para almacenar datos.
✅ Necesitas comparar objetos por contenido (no por referencia).
✅ Quieres imprimir datos fácilmente con toString().
✅ Necesitas crear copias modificadas con copy().
✅ Quieres aprovechar la desestructuración (val (nombre, edad) = usuario).

Usa una `clase normal` cuando:
❌ Necesitas comportamientos complejos, como métodos con lógica adicional.
❌ La identidad del objeto es más importante que sus valores.
❌ La clase tiene estados mutables o herencia (las data class no pueden ser `open`).

## 4. SUBCARPETA `Funciones de extensión`
* 1. Video: `Funciones de extensión`
Creamos un nuevo fichero `Extensions.kt`.
Modificamos el fichero `MainActivity.kt` con un pequeño ejemplo.
Modificamos añadiendo ejemplos en fichero `MediaAdapter.kt`.
Una función que se puede aplicar a cualquier clase independientemente que tengamos acceso a su código o no. Podemos añadir nuevas funciones a clases genericas o propias pero de forma externa implementada en un fichero aparte y sin tocar el fichero de la clase original. Simplemente añadiendo `Context`.

De esta forma estamos extrayendo la importaciones a un solo fichero de extensión y en caso de que cambiemos de libreria solo lo tendriamos que cambiar en dicho fichero y no en cada una de las implementaciones.

* 2. Video: `Tipos de Reified`
Modificamos el fichero `MainActivity.kt` con un ejemplo. Luego pasamos la funcion de ejemplo al fichero `Extensions.kt`.

Los tipos genericos sirven para poder aplicar una misma función en distintos tipos solo marcando con un generico cual es el tipo y donde se va a ir utlizandolo. El rpoblema que cuando accedemos a una funcion la infromación de ese tipo generico se pierde. Se solociona pasando la clase de tipo como argumento de la funcion,lo que hace que el codigo se vuelva un poco mas ilegible. Sin embargo en Kotlin tenemos los tipos
Reified.

Las tipos de Reified son tipos que se siguen manteniendo sus uso dentro de la función donde se utilizan, esto es util porque en muchas ocasiones simplifica el código. Tienen la palabra asociada `inline`.

* 3. Video: `Modificador inline`
En vez de a nivel de bits obtener la funcion, tenemos el contenido de esa función. Eso hace que lel tipo se piedda una vez hagamos la llamada a esa función. Con el inline se hace el truco de en vez de llamar a la función se esta copiando el codigo que esta dentor de esa funcion, sin perder la información del tipo.
Gracias a eso por ejemplo en el Reified no perdemos la informaicon del tipo y en las lambdas ya veremos que nos ayuda a optimizar ciertas cosas.

En general nos recomienda en no usarlos en funciones comunes porque el impacto es minimo pero en un Reified por ejemplo no solo es recomendado si no tambin es necesario.

## 5. SUBCARPETA `Descubriendo la magia de Kotlin`

* 1. Video: `Enumerados`
Editamos en el fichero `MediaItem.kt` para añadir un nuevo Enum del cual se pase por parametro a la data class MediaItem.
Editamos en el fichero `GetsItem.kt` añadiendo en cada elemento el nuevo parámetro del `MediaItem.kt`.

Representa valores fijos a través de una estructura de datos, en este caso tambien son clases.

* 2. Video: `Control de flujo`
Creamos un nuevo fichero `When.kt`.

Un control de flujo es como decidir porque camino seguimos segun ciertas condiciones. Dentro de Kotlin existen muchas como el  if, while, do-while, pero jay una que destaca sobre el resto que es el `when`.
El `when` equivale al `switch` de java pero con mucha más potencia. Puede recibir todo tipo de datos.

En cuanto al `if` tambien puede funcionar como una expresión. No existe el operador ternario.
El `for` difiere no se usa el indexado sino más recorriendo los elementos.

Vamos a hacer que en nuestra aplicación cuando un elemento sea de tipo video salga tambien una imagen de play. Para ello creamos un icono:
- `res/drawable/new vector asset` --> elegimos el icono de play lo ponemos en blanco y con dimension de 92x92 y lo guardamos.
- En el `view_media_item.xml` --> encapsulamos la imagen anterior en un FrameLayout (ViewGroup) y añadimos la nueva imagen del icono de play.
- En el `MediaAdapter` en la función `ViewHolder` añadimos el `When` para si es de tipo video se pueda ver la imagen nueva del icono de play.

* 3. Video: `Kotlin android extensions` (DEPRECADO)
Podemos acceder a las vistas que definamos en un XML desde nuestra clase Ktlin tan solo definiendo el indentificador. Sin tener que ahcer ningun findbyId ni nada por el estilo.

- `kotlin.android.synthetic` ha sido deprecado y eliminado en versiones recientes de Kotlin y Android. Esta funcionalidad permitía acceder a las vistas de los layouts sin necesidad de findViewById, pero ya no está disponible.
Google recomienda usar `View Binding`, ya que es más seguro y eficiente que kotlin.synthetic.

* 4. Video: `ViewBinding`
Comom podemos acceder a las vistas de android de una forma mucho más sencilla.
- Vamos al `build.grade (app)`
```java
    android {
        ...
        buildFeatures {
            viewBinding = true
        }
    }
```
Y compilamos dandole a `async`.

Por cada activity que tenganmos nos va a crear un binding correspondiente. Nuestro caso para `activity_main.xml` y `view_media_item.xml`.

Vamos a `MainActivity.kt`.
```java
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // ...
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(/*R.layout.activity_main*/ binding.root)

        val recycler = binding.recycler
        // ...
    }
```

Vamos a `MediaAdapter.kt`. Es un poco diferente.
```java
    private lateinit var binding: ViewMediaItemBinding

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): ViewHolder {
        // ...
         binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(/*view*/ binding.root)
        // ...
    }
```

Hay otra manera posible. Saltandose la parte del inflado.
```java
  class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ViewMediaItemBinding.bind(view) //  Saltandose la parte del inflado.
        // ...
        binding.mediaTitle.text = mediaItem.title
        // ...
  }
```

* 5. Video: `Funciones de Scope`
Son funciones que nos permiten crear un ambito en el que poder realizar multiples aplicaciones sobre nuna misma variable. De tal forma de no tener que repetir el nombre de la variable.

- Creamos un fichero `Scopes.kt`, vamos a hacer un pequeño ejemplo de un de método como es `apply`.
- Modificamos `MediaAdapter.kt` añadiendo un `Scope` ahora con el método `with` para no repetir la llamada del `binding` tantas veces en la funcion `ViewHolder`.

## 6. SUBCARPETA `Lambdas`
* 1. Video: `Qué es una lambda`
Es una representacion de una función dentro del lenguaje. Es un tipo especial dentro de Kotlin, al ser un tipo se puede usar una funcion como un elemento dentro de una variable, podemos pasar funciones a funciones a funciones, etc. Si solo hay parametro en el lambda se puede obviar usando la apralabra reservada `it`

- Creamos un fichero `Lambda.kt`.
Y hacemos lambda de ejemplo

- Modificamos el fichero `MediaAdapte.kt` al principio añadimos una interfaz y la definimos en la función `onBindViewHolder`. Para luego modificar el `MainActivity.kt` y que reciba ese nuevo parámetro.
Pero lueog cambiamos esa interfaz por una `expresion lambda` y asi vemos como se define (en `MediaAdapte.kt`) y como se declara (en `MainActivity.kt`).

* 2. Video: `Lambdas con receivers`
Es el equivalente a una función de extensión pero en lambdas.

En el `MainActivity.kt` esta varios ejemplos de un lambda de extensión.

### 6.1. ¿`Swift` utiliza `lambdas`?
Sí, Swift utiliza lambdas, pero en Swift se les conoce como closures. Son bloques de código autocontenidos que puedes pasar y ejecutar en diferentes partes del código, similar a las lambdas en Kotlin o Java.

- Sintaxis de un `Closure` en `Swift`
Un closure básico tiene esta forma:
```swift
{ (parámetros) -> TipoDeRetorno in
    // Código del closure
}
```
Ejemplo:
🔹 Se define una función anónima que recibe dos Int y devuelve un Int.
🔹 Se guarda en la variable suma.
🔹 Se puede llamar como si fuera una función normal.
```swift
let suma = { (a: Int, b: Int) -> Int in
    return a + b
}

let resultado = suma(3, 5) // resultado = 8
```

- `Closures` como `Parámetros de Función`
Los closures son muy usados en callbacks y funciones de orden superior.
Ejemplo con map(_:):
🔹 Se usa un closure para elevar cada número al cuadrado.
🔹 $0 representa el primer parámetro (Swift permite omitir nombres en closures cortos).
```swift
let numeros = [1, 2, 3, 4, 5]
let cuadrados = numeros.map { $0 * $0 }
print(cuadrados) // [1, 4, 9, 16, 25]
```

- `Closures` con `Captura de Variables`
Los closures pueden capturar variables del entorno donde fueron creados:
🔹 cantidad es capturada dentro del closure y se mantiene en memoria.
```swift
func crearSumador(_ cantidad: Int) -> (Int) -> Int {
    return { (numero: Int) in
        return numero + cantidad
    }
}

let sumarCinco = crearSumador(5)
print(sumarCinco(10)) // 15
```
- Closures con trailing closure syntax
Si el último parámetro de una función es un closure, puedes escribirlo fuera de los paréntesis:
🔹 { $0 + $1 } es un trailing closure.
🔹 Se usa en funciones como reduce, map, filter, etc.
```swift
func realizarOperacion(numeros: [Int], operacion: (Int, Int) -> Int) -> Int {
    return numeros.reduce(0, operacion)
}

let sumaTotal = realizarOperacion(numeros: [1, 2, 3, 4]) { $0 + $1 }
print(sumaTotal) // 10
```

- Comparación entre Closures en Swift y Lambdas en Kotlin
| Característica              | Swift (Closures)              | Kotlin (Lambdas)         |
|----------------------------|--------------------------------|--------------------------|
| **Definición**              | `{ (parámetros) -> Tipo in código }` | `{ parámetros -> código }` |
| **Uso implícito de parámetros** | `$0, $1 (omitir nombres)` | `it (para un solo parámetro)` |
| **Captura de variables**    | Sí, por referencia            | Sí, por referencia       |

- Conclusión
✅ Swift sí usa lambdas, pero los llama closures.
✅ Se usan en callbacks, funciones de orden superior y asincronía.
✅ Tienen sintaxis flexible y permiten capturar variables.
✅ Son equivalentes a las lambdas en Kotlin o funciones anónimas en JavaScript.

## 7. SUBCARPETA `Dando vida a nuestra app`

* 1. Video: `Delegación de propiedades`
Consite en delegar el getter y setter de una propiedad en una clase aparte se encarga de proveer o modifciar el valorcuando el programador utilice esa propiedad.
Podemos crear delegados personalizados o utilizar varios de la librerias de Kotlin.

El más conocido es el `lazy` para retrasar la ejecución del codigo que le indiquemos entre llaves en la lambda que le recibe hasta el momento que se utilice por primera vez esa properties. Esto sirve por si elmcodgio no tiene todos los componentes necesarios, entocnes en el momento que usemos lazy estara todo configurado para que no nos diese problemas.

Esta tambien el `obsevable` sirve para observar las modifciacione sde los properties y realizar una acción cuando halla una modificación.

Por ultimo esta el `vetoable` que es similar al observable solo que actua en otro momento diferente  en vez de justo despues de haberse modifcado la propiedad actua justo antes.

Añadir el `lateinit` que aunque no es un delegado como tal, viene a sustituir a `not null`qu elo qye permite es definir un property sin necesidad de darle un valor.

* Ejercicio 1: usa lazy para inicializar el adapter solo en el momento en que se vaya a
usar. En el `MainActivity.kt` lo añadimos.

* Ejercicio 2: usa observable para llamar a notifyDataSetChanged cuando los datos del adapter sean actualizados. En el `MediaAdapter.kt` lo añadimos y algo en el `MainActivity.kt`.

### 7.1. ¿Qué es `inflar` una `vista`?
En Android, inflar una vista significa convertir un archivo XML de layout en un objeto View que la aplicación puede manipular en tiempo de ejecución.

Cuando defines un diseño en un archivo XML (activity_main.xml, por ejemplo), ese archivo es solo una representación estática. Para poder usarlo en código Kotlin o Java, hay que “inflarlo”, es decir, convertirlo en una estructura de objetos en memoria que el sistema pueda renderizar en pantalla.

- Inflado Automático con setContentView (en Activity)
```java
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Infla el layout automáticamente
    }
}
```

- Inflado Manual con LayoutInflater (en Fragment o Adapter)
Cuando trabajas con Fragments, RecyclerView Adapters o Custom Views, necesitas inflar manualmente la vista.
```java
class MiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false) // Infla manualmente
    }
}
```

* 2. Video: `Colecciones`
Hay dos tipos de colecciones: las inmutabkles y las mutables.
Creamos un archivo llamado `Colecciones.kt` con ejemplos de las colecciones.

* Ejercicio: crea un menú de filtro que permita mostrar todos los elementos, solo fotos, o solo vídeos.
Creamos un nuevo recurso de tipo `Menu` y lo llamamos `main.xml`. Con tres elementos de solo mostrar fotos, videos o todo. Luego en el `MainActivity.kt` añadimos dos funciones para filtrar los items (list) segun el tipo que sea al inflar el menu.

* 3. Video: `Rangos`
Es una forma  de representar un listado de elementos que siguen una secuencia de una forma mucho mas sencilla.

* Ejercicio: Convierte GetMedia para que comience a usar un rango. (No lo puedo implementar yo, porque mis items de getMedia no cambian solo en un número). Pero dejo comentado el ejemplo.
Modificamos en el `MediaProvider.kt` (aunque lo tengo comentado).

* 4. Video: `Funciones infix`
Creamos un fichero `Infix.kt`

* 5. Video. `Objects`
Son clases que solo tiene una instancia. Es el equivalente a un Singleton.
Hay que tener cuidado con los Singleton por la concurrencia porque si tenemos una clase que solo esta almacenando una instancia pero entran dos hilos a la vez a generar dicha instancia puede ser que al final tengamos dos elementos/instancias de esa clase.

Cambian la palabra class por object y no pueden tener constructores porque son de una unica estancia sin argumentos.
Creamos un nuevo fichero `Objeto.kt`.

* Ejercicio: Usa un Object para GetMedia en vez de solo tener una función. Editamos el fichero `MediaProvider.kt`.  Y editamos luego el `MainActivity.kt`.

## 8. SUBCARPETA `Android KTX y Corrutinas`

* 1. Video. `Android KTX`
Son una serie de libreiras extras qu e estan creadas osbre las principlaes de AndroidX que añadiendo el sufijo `ktx` nos añade algunas funcionalizades extras sobre las mismas.

### 8.1. ¿Qué es un DSL?
En programación, DSL significa Domain-Specific Language (Lenguaje Específico de Dominio). Es un lenguaje de programación o configuración diseñado para un propósito específico en lugar de ser un lenguaje de propósito general como Kotlin, Swift o Java.

📌 Ejemplos de DSL en Kotlin
Kotlin usa muchos DSLs para hacer el código más legible y expresivo.
En lugar de escribir código estándar, puedes usar un DSL en Kotlin para configurar un RecyclerView:
```java
recyclerView.apply {
    layoutManager = GridLayoutManager(context, 2)
    adapter = myAdapter
}
```

* 2. Video. `Properties de extensión y Sobrecarga de Operadores`
Nuevo fichero `PropertiesExt.kt`

* 3. Video. `Corrutinas`
Son una forma de hacer peticiones asincronas de forma sincrona. Por ejemplo una petición a un servidor, como te vas a tener que salir del hilo principal para no bloquearlo. De normal se haria un callback para salirte del hilo principal realizar la llamda a la Api o base de datos y alfinalizar le callback volver a al hilo principal.

La corrutina spor detras vana generar esos callback por nosotros y nos vamos a olvidar de todo lo demás simplemente identificamos en que irlo queremos que se ejecute la peticio, recuperamos el valor y en la siguiente linea lo podemos utilizar sin ningun problema.

Añadir dependencias de corrutinas `implementation(libs.sdkcoroutines)` en `gradle ::app`
Creado fichero `Corrutinas.kt`.
Modifica añadiendo `ProgressBar` en el fichero `activity_main.xml`.
Modifica añadiendo tiempo de espera en la función de cargar los datos `MediaProvider.kt`
Modifica haciendo que apse la carga en un hilo secundario mientras sigue ejecutandose el hilo principal `mainActivity.kt`

* 4. Video. `Coroutine Scope`
Como modificar el `GlobalScope`. Es un ambito global, solo se debe de utilizar en situaciones donde lo que creemos tiene que sobrevivir a todo el ciclo de vida de nuestra aplicaición.

Modificado el `MainActivity.kt`.

* 5. Video. `User Lifecycle Scope`
Lo que hicimos en el punto anterior (*4) hay una forma más rapida y mejor de hacer de forma nativa.

Debemos importar una nueva dependecia que nos lo realziar atodo de una forma mucho mas sencilla.

Añadir dependencias de corrutinas `implementation()` en `gradle ::app` (poniendo `lifecycle`).
Modificado el `mainActivity.kt` (comentando todo lo del punto *4 y añadiendo solo la palabra de `lifecycleScope`).

## 9. SUBCARPETA `Creando la actividad de detalle`

* 1. Video. `Nulidad y tipos nullables`
Creado fichero `Nulos.kt`.
Cremamos la actividad detalles:
En el `MediaItem.kt` añadi un parametro id.
En el `MediaProvider.kt` añadi el parametro id a cada elemento.
Creamos un nuevo activity. `DetailActivity.kt` y `activity_detail.xml`.
En el `MainActivity.kt` en la `Delegación de propiedades` añado `vista de detalles`
En el `extension.kt` en la funcion de `Reified` se modifica.

* 2. Video. `Clases selladas`
Con la nomenclatura `sealed`. Son como enumerados con superpoderes porque pueden contener estados.

Creamos nuevo fichero `ClaseSelladas.mk`.
Creamos nuevo fichero `Filter.mk`.
Editamos el `MainActivity.kt`. Función `onOptionsItemSelected`, `updateItems` y `getFilteredItems`.

* 3. Video. `Type Alias`
Sirve para simplificar si tenemos tipos muy complejos. Es una forma de dar un nombre diferente a un tipo.

## 10. SUBCARPETA - VIDEO `Compatibilidad con Java`
Interpolaridad con Java.

## 11. SUBCARPETA `Android Arquitecturas`

* 1. Video. `MVP`

* 2. Video. `MVVM`

* 3. Video. `Testing`

* 4. Video. `Koin`
Es para inyección de dependencias. (Servis Locator).

## 12. SUBCARPETA - VIDEO `Kotlin DSL`
Es la variante de Kotlin.


