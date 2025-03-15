package es.upsa.a1_prueba1_android_kotlin.pruebas

sealed class ClaseSellada {

    class Add(val value:Int): ClaseSellada()
    class Sub(val value:Int): ClaseSellada()
    class Mul(val value:Int): ClaseSellada()
    // class Incremento: ClaseSellada() // al ser una unica instancia s epuede hace run objet en vez de class
    object Incremento: ClaseSellada()
}

fun doOp(x: Int, op: ClaseSellada): Int {
    return when (op){
        is ClaseSellada.Add -> x + op.value
        is ClaseSellada.Sub -> x - op.value
        is ClaseSellada.Mul -> x + op.value
        ClaseSellada.Incremento -> x + 1
    }
}