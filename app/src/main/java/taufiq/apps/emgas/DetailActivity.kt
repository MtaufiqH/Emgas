package taufiq.apps.emgas

import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.core.data.Resource
import taufiq.apps.core.domain.Game
import taufiq.apps.emgas.databinding.ActivityDetailBinding
import taufiq.apps.emgas.viewmodels.DetailViewModel

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val binding by viewBinding<ActivityDetailBinding>()
    private val detailModels by viewModels<DetailViewModel>()
    private val dataGame by lazy {
        intent.getParcelableExtra<Game>(DETAIL_KEY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel(dataGame!!.gameId)
        supportActionBar?.title = dataGame!!.name
    }

    private fun observeViewModel(id: String){
        detailModels.getDetailGame(id).observe(this) {
            when(it){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is  Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    setupDetail(it.data)
                }

                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun setupDetail(data: Game?) {
        binding.gameTitle.text = data?.name
        binding.gameRating.rating = data?.rating?.toFloat() ?: 0f
        Glide.with(this)
            .load(data?.imageUrl)
            .into(binding.gameImage)
        binding.itemReleased.text = data?.released ?: "-"
        binding.gameDescription.text = data?.description ?: "-"

        //setting favorite button
        var currentState = data?.isFavorite
        setAsFavorite(currentState)
        binding.fabFavorite.setOnClickListener{
            currentState = !currentState!!
            detailModels.setFavorite(data!!, currentState!!)
            setAsFavorite(currentState)

        }
    }

    private fun setAsFavorite(currentState: Boolean?) {
        if (currentState == true) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_favorite_true))
        } else
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_favorite))
    }


    companion object {
        const val DETAIL_KEY = "DETAIL_KEY"
    }
}