package es.upsa.a1_prueba1_android_kotlin.pruebas

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun main(){

}

// antes de nada añadir la dependencia de las corrutinas en nuestro proyecto (grandle:app)
// Buscamos `Coroutines` y lo añadimos

fun testCorrutinas() {

    GlobalScope.launch( Dispatchers.Main ) { // Hilo principal porque los datos que recuperemos los queremos pintan en la interfaz (en el hilo principal)

        // la fecha (en la izquierda) significa que e suna llamada a una función de suspension, cuando llegue a hay se bloqueara y se cambiara al hilo del servidor y por lo tanto el hilo principal estara libre para utizarse y una vez que tengamos el resultado se devuelve el control a la corrutina del hilo principal y la corrutina puede seguir ejecutandose.
        val result = withContext(Dispatchers.IO) {  // es un apeticion a un servidor por lo tanto tien que estar en el hilo deficados a los servidores
            heavyTask()
        }

        print(result)
    }

}

fun heavyTask(): String = "Hello"