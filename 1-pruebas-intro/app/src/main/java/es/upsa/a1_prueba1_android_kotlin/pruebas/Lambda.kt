package es.upsa.a1_prueba1_android_kotlin.pruebas




fun main(){
    testLambda()
}

// ________ Declarar Lambda ________
//  val sum: (Int, Int) -> Int
// ________ Utilizar Lambda ________
//    { x,y ->
//       val z = x + y
//       z
//    }


fun testLambda() {

    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val mul: (Int, Int) -> Int = { x, y -> x * y }

    val resultSuma = doOp(5, 10, sum)
    val resultMul = doOp(5, 10, mul)

    val resultResta = doOp(5, 10) { x, y ->
        x - y
    }

    val resultSumaFunc = doOp(5, 10, ::funcSum) // mediante la referencia a la función con '::', se puede utilizar como si fuera una lambda

    println("resultSuma $resultSuma")
    println("resultMul $resultMul")
    println("resultResta $resultResta")
    println("resultSumaFunc $resultSumaFunc")

}

fun doOp( x: Int, y:Int, op: (Int, Int) -> Int ) = op(x, y)

fun funcSum (x: Int, y: Int): Int = x + y // tiene la misma estructura que la lambda