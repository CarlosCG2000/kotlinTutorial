package es.upsa.a1_prueba1_android_kotlin.app.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.upsa.a1_prueba1_android_kotlin.R

//________________`Funciones de extensión`________________
// El primer parametro que hay que pasar en 'makeText' es el contexto pero al estar fuera d ela clase no tiene contexto. Entonces al hacerlo funcion de extension `Context.` hace esto que vaya a recibir el contexto donde se implemente de estmanera ya no dara error en el this
// _____________________ EN FICHERO 'MainActivity.kt' _____________________
fun Context.toast(message: String, length:Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this /*contexto*/, message, length).show()
}

// _____________________ EN FICHERO 'MediaAdapter.kt' _____________________
fun RecyclerView.ViewHolder.toast(message: String){
    // contentra el 'itemView' el 'RecyclerView.ViewHolder' y sacaremos su contexto
    itemView.context.toast(message)
}

fun ViewGroup.inflate(@LayoutRes layoutRes:Int): View { // @LayoutRes para avisarnos si es el tipo correcto
    return LayoutInflater.from(this.context)
        .inflate(R.layout.view_media_item, this, false)
}

fun ImageView.loadUrl(url: String ){
    Glide.with(this).load(url).into(this)
}

//________________`Tipos de Reified` (Se aplica en el 'MainActivity.kt')________________
// La funcion 'startActivity()' que recibira un generico para saber la actividad del destino. Este tipo generico solo pueden ser uno que extienda de Activity. La funcion queremos que aplique sobre el contexto para usar el this como tal.
inline fun <reified T: Activity> Context.startActivity(vararg pairs: Pair<String, Any?>){
    // val bundle = bundleOf(*pairs) // listado de pares con una clave y un valor, *pairs el * es para descapsularlo.
    /*val intent =*/ Intent(this/*es el contexto*/, T::class.java).apply {  // los que nos pasa es que no podemos utilizar el T como un Reified, se denomina el borrado de tipos que implica que cuando una clase se compila se pierde la info del tipo dentro de esas funciones. Solución añadir en la funcion 'reified' y el 'inline' para que funcione.
        this.putExtras(bundleOf(*pairs) )
    }.also(::startActivity)

    // startActivity(intent)
}

