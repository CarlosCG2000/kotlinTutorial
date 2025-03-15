package es.upsa.a1_prueba1_android_kotlin.app.ui

import android.util.Log

interface Logger {

    // val tag: String = javaClass.simpleName // ❌ No se pueden añadir estado (properties)
    val tag: String // lo que si podemos es sobreescribir el get y hacer que se pase un contenido diferente. Ya que no se esta almacenando el estado de ningun tipo ya que el get ya existe en la clase
        get() = javaClass.simpleName

    fun logI(message: String) {
        Log.i(tag, message)
    }

    fun logE(message: String) {
        Log.e(tag, "Error al $message")
    }

   // ... demás log

}