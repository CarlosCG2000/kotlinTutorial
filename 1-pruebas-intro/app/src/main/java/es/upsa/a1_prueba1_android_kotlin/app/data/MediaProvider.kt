package es.upsa.a1_prueba1_android_kotlin.app.data

import androidx.annotation.WorkerThread

object MediaProvider {

    //  (Genera la lista de datos)
    @WorkerThread // no se pueda ejecutar en el hilo principal
    fun getItems(): List<MediaItem> {

        Thread.sleep(2000) // se ejecute en 2 segundos, para la prueba del ProgressBar

        return listOf(
            // MediaItem("Title 1", "https://placekitten.com/200/200?image=1"),
            MediaItem(
                1,
                "Hello",
                "https://cataas.com/cat/says/hello",
                MediaItem.Type.PHOTO
            ), // imagen ramdon de gato
            MediaItem(2, "Money", "https://cataas.com/cat/says/money", MediaItem.Type.PHOTO),
            MediaItem(3, "Dog", "https://cataas.com/cat/says/dog", MediaItem.Type.VIDEO),
            MediaItem(4, "Up", "https://cataas.com/cat/says/up", MediaItem.Type.PHOTO),
            MediaItem(5, "Ji", "https://cataas.com/cat/says/ji", MediaItem.Type.PHOTO),
            MediaItem(6, "Cold", "https://cataas.com/cat/says/cold", MediaItem.Type.VIDEO),
            MediaItem(7, "Hot", "https://cataas.com/cat/says/hot", MediaItem.Type.PHOTO),
            MediaItem(8, "Ugly", "https://cataas.com/cat/says/ugly", MediaItem.Type.VIDEO),
            MediaItem(9, "Fat", "https://cataas.com/cat/says/fat", MediaItem.Type.PHOTO),
            MediaItem(10, "Little", "https://cataas.com/cat/says/little", MediaItem.Type.PHOTO)
        )
    }
}

// _________________ Ejemplo de rangos _________________

//fun getItemsRango(): List<MediaItem> = (1..10).map {
//    MediaItem($it, "Title $it", "https://placekitten.com/200/200?image=$it",
//        if(it % 3 == 0) Type.VIDEO else Type.PHOTO)
//}

//// Igual a esto:
//listOf(
//// MediaItem("Title 1", "https://placekitten.com/200/200?image=1"),
//MediaItem("Title 1", "https://placekitten.com/200/200?image=1", Type.PHOTO),
//MediaItem("Title 2", "https://placekitten.com/200/200?image=2", Type.PHOTO),
//MediaItem("Title 3", "https://placekitten.com/200/200?image=3", Type.VIDEO),
//MediaItem("Title 4", "https://placekitten.com/200/200?image=4", Type.PHOTO),
//MediaItem("Title 5", "https://placekitten.com/200/200?image=5", Type.PHOTO),
//MediaItem("Title 6", "https://placekitten.com/200/200?image=6", Type.VIDEO),
//MediaItem("Title 7", "https://placekitten.com/200/200?image=7", Type.PHOTO),
//MediaItem("Title 8", "https://placekitten.com/200/200?image=8", Type.PHOTO),
//MediaItem("Title 9", "https://placekitten.com/200/200?image=9" , Type.VIDEO),
//MediaItem("Title 10", "https://placekitten.com/200/200?image=10",Type.PHOTO)
//)
