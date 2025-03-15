package es.upsa.a1_prueba1_android_kotlin.app.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.upsa.a1_prueba1_android_kotlin.R
import es.upsa.a1_prueba1_android_kotlin.app.data.MediaItem
import es.upsa.a1_prueba1_android_kotlin.app.ui.inflate
import es.upsa.a1_prueba1_android_kotlin.app.ui.loadUrl
import es.upsa.a1_prueba1_android_kotlin.app.ui.toast
import es.upsa.a1_prueba1_android_kotlin.databinding.ViewMediaItemBinding
import kotlin.properties.Delegates

// Creamos el ViewHolder
// Este MediaAdapter es el puente entre los datos (items) y la interfaz (RecyclerView).
// 	1. Recibe la lista items: List<MediaItem>.
// 📌 Recibe: Una lista de MediaItem (cada uno con un título y una imagen).
// 📌 Extiende: RecyclerView.Adapter<ViewHolder>, lo que obliga a implementar tres métodos clave:
class MediaAdapter(/*val*/ items: List<MediaItem> = emptyList<MediaItem>(),
                   val listener: /*Listener*/ (MediaItem) -> Unit): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    // private lateinit var binding: ViewMediaItemBinding // `ViewBinding`

    // ____________ `Delegación de propiedades` ____________
    var items: List<MediaItem> by Delegates.observable(items){ p, old, new -> // p:property
        notifyDataSetChanged()
    }
    // ______________________________________________________

    // Métodos requeridos de RecyclerView donde se crea y vincula las vistas:
    // 1.  Crea cada ítem. Infla el XML (view_media_item.xml) de cada fila.
    // 	•	parent: El RecyclerView al que pertenece el ítem.
    //	•	viewType: Si tuvieras distintos tipos de vista, podrías diferenciarlos aquí.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): ViewHolder {
        // Convierte 'view_media_item.xml' en un objeto View que se puede usar en Kotlin.
    //   val view = LayoutInflater.from(parent.
    //                          .inflate(R.layout.view_media_item, parent, false)
        // binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context)) // `ViewBinding`
        val view = parent.inflate(R.layout.view_media_item ) // funcion de extensión

        return ViewHolder(view /*binding.root*/) // Luego, lo pasa al 'ViewHolder' para que lo administre.
    }

    // 2. Asigna los datos a cada vista.
    // 	•	Obtiene el MediaItem correspondiente a la position.
    //	•	Llama al holder.bind(item) para actualizar los datos en la vista.
    override fun onBindViewHolder( holder: ViewHolder, position: Int ) {
        val item: MediaItem = items[position] // Obtiene el MediaItem en esa posición
        holder.bind(item) // Llama a la función bind() en ViewHolder

        holder.itemView.setOnClickListener { listener/*.onClick*/(item) } // De la interfaz ejecutamos el metodo .onClick(item), en vez de eso ahora llama,os directamente a la lambda
    }

    // 3. Devuelve el total de elementos.
    override fun getItemCount(): Int = items.size // la canitda de los items

    // ________ El ViewHolder se encarga de asignar los datos a cada elemento de la RecyclerView.________
    // Mantiene las referencias a las vistas para cada elemento.
    //• Asigna el título de mediaItem.title al TextView.
    //•	Usa Glide para cargar la imagen desde mediaItem.url y mostrarla en ImageView.
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val binding = ViewMediaItemBinding.bind(view) // ViewBinding. Saltandose la parte del inflado.

        // Busca el TextView (mediaTitle) y el ImageView (mediaThumb) dentro del view_media_item.xml.
        // SE REALZIA AHORA MEDIANTE EL BINDING, POR ESO SE COMENTA.
        // private val title: TextView = view.findViewById<TextView>(R.id.mediaTitle)
        // private val thumb: ImageView = view.findViewById<ImageView>(R.id.mediaThumb)
        // private val videoIndicator: ImageView = view.findViewById<ImageView>(R.id.mediaVideoIndicator)

        fun bind(mediaItem: MediaItem) { //  bind() → Asigna valores a la vista
/**
            /*title*/ binding.mediaTitle.text = mediaItem.title //  Muestra el título en el TextView.

            //  Glide.with(thumb).load(mediaItem.url).into(thumb) // Carga la imagen con Glide.
            /*thumb*/ binding.mediaThumb.loadUrl(mediaItem.url) // función de extension

            /*videoIndicator*/ binding.mediaVideoIndicator.visibility = when (mediaItem.type){ // opt + p: crea las posiblilidades
            MediaItem.Type.PHOTO -> View.GONE // Se oculte la vista
            MediaItem.Type.VIDEO -> View.VISIBLE // Sea visible la vista
            }

            /*itemView*/ binding.root.setOnClickListener {
            toast(mediaItem.title) // es una funcion de extensión
            }
 */
            // En vez de aplicar tantas veces el Bind a través de un Scope lo hacemos solo una vez el Binding y dentro a traves de this nombramos a dicho Binding
            with(binding){
                /*this.*/mediaTitle.text = mediaItem.title
                /*this.*/mediaThumb.loadUrl(mediaItem.url)
                /*this.*/mediaVideoIndicator.visibility = when (mediaItem.type){ // opt + p: crea las posiblilidades
                    MediaItem.Type.PHOTO -> View.GONE // Se oculte la vista
                    MediaItem.Type.VIDEO -> View.VISIBLE // Sea visible la vista
                }
                /*this.*/root.setOnClickListener {
                    toast(mediaItem.title) // es una funcion de extensión
                }
            }
        }
    }




}