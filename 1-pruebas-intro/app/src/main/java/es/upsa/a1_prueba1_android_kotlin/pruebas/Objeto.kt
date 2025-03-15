package es.upsa.a1_prueba1_android_kotlin.pruebas


fun main(){
    println(miObjeto.x)

    val miObjEnLinea = object {
        val x = 50
        val y = "Hello"
    }

    println(miObjEnLinea.x)

}

object miObjeto {
    val x = 20
    val y = "Hello"
}

class ejemplo {
    // lo que escribamos lo van a poder utilizar todas las instancias de dicha clase (ejemplo)
    companion object {

    }
}