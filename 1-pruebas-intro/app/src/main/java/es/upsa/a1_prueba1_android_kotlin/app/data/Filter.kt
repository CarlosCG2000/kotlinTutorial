package es.upsa.a1_prueba1_android_kotlin.app.data

// clase sellada
sealed class Filter {
    // necesitan siempre heredar de las clase sellada para poder ser un subclase syuda
    object None : Filter()
    class ByType(val type: MediaItem.Type) : Filter()
}