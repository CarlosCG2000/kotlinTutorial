package es.upsa.a1_prueba1_android_kotlin.app.data

// •	Representa un item con un título (title) y una imagen (url).
// •	Se usará para poblar el RecyclerView.
data class MediaItem (val id:Int, val title:String, val url: String, val type:Type){
    enum class Type  {PHOTO, VIDEO }
}

// Clase con properties para poder guardarla como un estado con getter y setter
//Cada MediaItem representa un elemento de la lista con:
//•	title: Texto a mostrar.
//•	url: URL de la imagen.
