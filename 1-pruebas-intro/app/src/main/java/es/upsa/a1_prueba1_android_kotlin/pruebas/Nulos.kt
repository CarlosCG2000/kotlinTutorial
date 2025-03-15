package es.upsa.a1_prueba1_android_kotlin.pruebas


fun main(){
    test()
}

fun test(){
    var x:Int? = null // Opcional puede ser Int to nulo

    var l: Long = x?.toLong() ?: 0

}