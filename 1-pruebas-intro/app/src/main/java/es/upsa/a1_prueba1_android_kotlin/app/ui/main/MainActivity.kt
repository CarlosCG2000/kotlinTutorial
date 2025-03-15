package es.upsa.a1_prueba1_android_kotlin.app.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import es.upsa.a1_prueba1_android_kotlin.app.data.Filter
import es.upsa.a1_prueba1_android_kotlin.app.ui.Logger
import es.upsa.a1_prueba1_android_kotlin.app.data.MediaItem
import es.upsa.a1_prueba1_android_kotlin.databinding.ActivityMainBinding
import  es.upsa.a1_prueba1_android_kotlin.app.data.MediaItem.*
import es.upsa.a1_prueba1_android_kotlin.app.data.MediaProvider
import es.upsa.a1_prueba1_android_kotlin.R
import es.upsa.a1_prueba1_android_kotlin.app.ui.detail.DetailActivity
import es.upsa.a1_prueba1_android_kotlin.app.ui.startActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// import kotlin.android.synythetic.main.activity_main.* // DEPRECADO

class MainActivity() : AppCompatActivity(), Logger /*, CoroutineScope*/  // Logger: clase para simplificar los logs
{
    // override val tag:String = "El tag que queramos" // variable optativa de la clase 'Logger' por si no queremos la de por defecto que sea  'javaClass.simpleName'
    private lateinit var binding: ActivityMainBinding // `ViewBinding`

    // _______________ `Delegación de propiedades` + `Luego vista de detalles`_______________
    // Hasta que no se ejecute el Adapter y se ejecute (get de la property) no se ejecutará el contenido de la lambda
    private val adapter = MediaAdapter { // Para navegar en cuanto se pulse a un item en concreto a su informacion en concreto
        startActivity<DetailActivity>(DetailActivity.EXTRA_ID to it.id) // es una extension
        // toast(it.title)
    }
//    private val adapter by lazy  { MediaAdapter ( MediaProvider.getItems() )
//                                                { mediaItem -> // Hacemos la lambda
//                                                    toast(mediaItem.title)
//                                                }
//                                }
    //  _____________________________________________

    // __________________ Coroutine Scope _________________
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job // en el hilo principal y el job: el trabajo al que se asignen esas corrutinas de tal forma qe si destruimos ese trabajo (job) todas las corrutinas aosciadas se cancelaran tambien
//    lateinit var  job: Job
//
//    override fun onDestroy() {
//        job.cancel()
//        super.onDestroy()
//    }
    // _________________________________________________

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // job = SupervisorJob() // Coroutine Scope

        binding = ActivityMainBinding.inflate(layoutInflater) // `ViewBinding`

        setContentView(/*R.layout.activity_main*/ binding.root)

//________________`Interfaces`________________
//      Log.i(javaClass.simpleName, "Estoy aquí")
        logI("Estoy aquí") // Viene de la extensión de la clase que he añadido Logger

//________________`Conceptos básicos`________________
//        val message = findViewById<EditText>(R.id.mes) // Variables
//        val button = findViewById<Button>(R.id.button)
//
//        button.setOnClickListener {
//            toast("Hola ${message.text}") // String Templates
//        }

        // _________________________ `ViewBinding` ___________________
        // Busca el RecyclerView en activity_main.xml.
        // val recycler = findViewById<RecyclerView>(R.id.recycler)

        // val recycler = binding.recycler

        // Añadimos un lambda para probar.
        // Crea una instancia de MediaAdapter con la lista getItems(). Asigna el adapter al RecyclerView.recyclerView.apply {
        //    layoutManager = GridLayoutManager(context, 2)
        //    adapter = myAdapter
        //}

        binding.recycler.adapter = adapter

//        binding.recycler.adapter = MediaAdapter(getItems()
//        /* //En vez de un interface que sea para probar la Lambda
//                            , object: Listener {
//                                override fun onClick(mediaItem: MediaItem) {
//                                    toast(mediaItem.title)
//                                }
//        */)
//        { mediaItem -> // Hacemos la lambda
//                toast(mediaItem.title)
//        }

        updateItems() // cuando se cargue el Activity tenga todos los items

        // ____________ `Delegación de propiedades` ____________
        // adapter.items = MediaProvider.getItems() // esto lo que haria es llamar a notifyDataSetChanged y actualizaria la vista con los nuevos datos

        // toast("Hola Mundo") // es una función de extensión se sabe porque se ve en cursiva, hereda el contexto del MainActivity

        //________________`Tipos de Reified`________________
        // estoy navegando a mi mismo porque tenemos más vistas.
        // val intent = Intent(this, MainActivity::class.java)
        // startActivity(intent)
        // gracias a la funcion de tipo Reified se pasa a:
//      startActivity<MainActivity>()

        // _________________ Llamada a `Lambdas con receivers` ___________________
//        val textView: TextView = TextView(this).apply { // es un lambda el Scope que se usa
//            text = "Hello"
//            hint = "Goodbye"
//            textSize = 20f
//        }
//
//        val textViewPers: TextView = TextView(this).applyPers { // nuestra propia extension lambda que realiza lo mismo que el Scope
//            text = "Hello"
//            hint = "Goodbye"
//            textSize = 20f
//        }
    }
//________________`Conceptos básicos`________________
    // Es un pequeño mensaje emergente que se muestra en la pantalla durante un corto período de tiempo y desaparece automáticamente
//    private fun toast(message: String) {
//        Toast.makeText(this /*MainActivity*/, message, Toast.LENGTH_SHORT).show()
//    }

    // ____________ Ejercicio de colecciones:filtrar items por tipo ____________
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // en funcion del elemento que hayas seleccionado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val filter = when (item.itemId) {
            R.id.filter_photos -> Filter.ByType(Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(Type.PHOTO)
           else -> Filter.None
        }

         updateItems(filter = filter/*item.itemId*/)
//        adapter.items = MediaProvider.getItems().let { media ->
//                when(item.itemId) {
//               R.id.filter_photos -> media.filter { it.type == Type.PHOTO }
//               R.id.filter_videos -> media.filter { it.type == Type.VIDEO }
//               R.id.filter_all -> media
//               else -> emptyList()
//            }
//        }

        return super.onOptionsItemSelected(item)
    }
    // ____________________________________________________________

    // ____________ Ejercicio de Corrutinas  ____________
    private fun updateItems(filter: Filter = Filter.None /*:Int = R.id.filter_all*/) { // todos los items por defecto
        /*GlobalScope.*/lifecycleScope.launch(/*Dispatchers.Main*/) { // en el hilo principal (de la interfaz), gracias a la definicion del Coroutine Scope (mas arriba) se comentan esas dos cosas en la linea. Añadido la nueva dependecia ya solo seria utilizar el 'lifecycleScope'
            binding.progress.visibility = View.VISIBLE

            adapter.items = withContext(Dispatchers.IO) { // en el hilo de servicios
                // MediaProvider.getItems()
                getFilteredItems(filter)
            }

            binding.progress.visibility = View.GONE
        }
    }

    // Filtro de items
    private fun getFilteredItems(filter: Filter) : List<MediaItem> {
        return MediaProvider.getItems().let { media ->
            when (filter) {
                is Filter.None -> media
                is Filter.ByType -> media.filter { it.type == filter.type }
            }
        }
    }

}

// _________________ Declaración `Lambdas con receivers` ___________________
// Función de extensión lambda de Text View
fun TextView.applyPers(body: TextView.() -> Unit): TextView { // TextView.() es el parámetro como una lambda de extensión
    this.body() // ejecute la funcion lambda
    return this // y que retorne el propio TextView
}

// Si lo queremos en vez de solo para TextView sea generico.
fun <T> T.applyPersGen(body: T.() -> Unit): T{
    this.body()
    return this
}

// Ejemplo pero en vez del Scope de 'apply' del de 'run'
fun <T, U> T.runPersGen(body: T.() -> U): U{ // tiene que ser una salida que no tiene porque corresponderse al mismo del que tiene en la función
    return this.body()
}

// Ejemplo pero en vez del Scope de 'apply', 'run' del de 'with'
fun <T, U> withPersGen(receiver: T, body: T.() -> U): U { // Necesita pasarle por parámetro el generico
    return receiver.body()
}

// Ejemplo pero en vez del Scope de 'apply', 'run', 'with' es el de 'let'
fun <T, U> T.letPersGen(body: (T) -> U): U{ // en vez d ese run alambda con receiver es una lambda normal
    return body(this)
}










