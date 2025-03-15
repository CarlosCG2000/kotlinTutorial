package es.upsa.a1_prueba1_android_kotlin.pruebas

import android.content.Context
import android.widget.TextView


fun main(){

}

fun testSinScope(context: Context){
    val textView = TextView(context)
    textView.text = "hola"
    textView.hint = "adios"
    textView.textSize = 15f
}

fun testConScopeApply(context: Context){
    val textView = TextView(context).apply {
        text = "hola"
        hint = "adios"
        textSize = 15f
    }
}

/// Hay  muchos mas como  with, let...