package es.upsa.a1_prueba1_android_kotlin.pruebas

import android.view.View
import android.view.ViewGroup


fun main(){

}

fun propertiesExtTest(viewGroup: ViewGroup){
    viewGroup.childCount
    // Equivalente
    viewGroup.size

    viewGroup.getChildAt(0)
    // Equivalente
    viewGroup[0]
}

// Propiedad de extension de ViewGroup
val ViewGroup.size: Int
    get() = childCount

/*operator: Marcarlo como operador*/ // Propiedad de extension
operator fun ViewGroup.get(index:Int): View = this.getChildAt(index)


