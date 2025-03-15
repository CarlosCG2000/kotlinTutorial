package es.upsa.a1_prueba1_android_kotlin.pruebas

import kotlin.collections.iterator


fun main() {
    testList()
}

fun testList() {
    // _______________________________________________
    // 1. Lista normal inmutable
    val listOfInt = listOf<Int>( 5, 4, 2, 6)
    val listOfAny = listOf<Any>(2, 4, 5, "String", true)

//    listOfInt.filter { num -> // es una lambda
//        num % 2 == 0
//    }

    val result = listOfInt.filter { it % 2 == 0 }  // es una lambda
                            .map { it.toString() }
                            .sorted()

    var newList = result + 3 // añade un nuevo elemento con el numero 3

    println(newList)
    // _______________________________________________
    // 2. Lista mutable
    val listMutable = mutableListOf<Int>(3, 2, -3, 5)

    listMutable.add(4)
    listMutable.removeAt(0)
    println(listMutable)
    listMutable.removeIf { it < 0 }
    println(listMutable)
    // _______________________________________________
    // 3. Set
    val set = setOf<Int>(3, 4, 5, 6, 3) // es como una lista pero no permite repetir elementos, es este caso el segundo 3 lo eliminaria
// _______________________________________________
    // 4. Mapa
    val map = mapOf(Pair("a", 1), Pair("b", 2)) // pueden ser desestructurados como una dataclass

    for((key, value) in map) { // no hay que desuctrurarlo ya viene por defecto
        println("Clave $key Valor $value")
    }
    // _______________________________________________
    // Secuencia
    // secuencias, retrasan lo maximo posible las operaciones de forma que solo necesitemos hacer uno operación por cada uno delos elementos de la vista. Solo merece la pena cunado la soperacioens sena complejas olistas muy grandes
    val resultSecuencias = listOfInt.asSequence() // convertimos en secuencia
                                    .filter { it % 2 == 0 }
                                    .map { it.toString() }
                                    .toList() // volvemos a la lista
    // _______________________________________________
}
