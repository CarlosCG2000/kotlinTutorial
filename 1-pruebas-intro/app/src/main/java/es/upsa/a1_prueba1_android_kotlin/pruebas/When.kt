package es.upsa.a1_prueba1_android_kotlin.pruebas

import android.view.View
import android.view.ViewGroup
import android.widget.TextView


fun main(){

}

fun testWhen(view: View) {

    // Aunque no devuelva nada un metodo siempre se puede asignar a una variable porque estara devolviendo al menos el objeto Unit (Void).
     val result: Unit = when (view) {
         is TextView -> println(view.text) // esta en verde porque se hace el cast automaticamente (Smart cast) al saver ya que es de tipo TextView
         is ViewGroup -> println(view.childCount)
         else -> println("Nada encontrado")
     }

    val resultString: String = when (view) {
        is TextView -> view.text.toString() // esta en verde porque se hace el cast automaticamente (Smart cast) al saver ya que es de tipo TextView
        is ViewGroup -> view.childCount.toString()
        else -> "Nada encontrado"
    }

    // When sin argumento, seria un if y else
    val resultSinArgumento = when {
        view is TextView -> { view.text.toString(); "Siii" }
        2 > 3 -> "Si"
        else -> "Nada encontrado"
    }

}


