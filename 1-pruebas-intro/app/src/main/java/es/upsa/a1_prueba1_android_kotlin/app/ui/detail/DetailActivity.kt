package es.upsa.a1_prueba1_android_kotlin.app.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import es.upsa.a1_prueba1_android_kotlin.app.data.MediaItem
import es.upsa.a1_prueba1_android_kotlin.app.data.MediaProvider
import es.upsa.a1_prueba1_android_kotlin.app.ui.loadUrl
import es.upsa.a1_prueba1_android_kotlin.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    companion object { // es un object que comparte todas las instancias de una misma clase
        val  EXTRA_ID = "DetailActivity:id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val itemId = intent.getIntExtra(EXTRA_ID, -1) // si no lo encuentra que devuelva -1

        lifecycleScope.launch {
            val items = withContext(Dispatchers.IO) {
                MediaProvider.getItems()
            }

            val item: MediaItem? = items.firstOrNull{ it.id == itemId }

            item?.let {
                supportActionBar?.title = item.title
                binding.detailThumb.loadUrl(item.url)
                binding.detailVideoIndicator.visibility = when(item.type) {
                    MediaItem.Type.PHOTO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }
    }
}