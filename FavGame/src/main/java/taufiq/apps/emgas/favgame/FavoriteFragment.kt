package taufiq.apps.emgas.favgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.emgas.DetailActivity
import taufiq.apps.emgas.favgame.databinding.FragmentFavoriteBinding


/**
 * Created By Taufiq on 5/19/2021.
 *
 */
@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val binding: FragmentFavoriteBinding by viewBinding()
    private val viewModel by viewModels<FavoriteViewModel>()
    private val adapters by lazy {
        FavAdapters(requireContext())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        observableInit()
    }


    private fun initView() {
        binding.favRecyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.favRecyclerview.adapter = adapters
        adapters.itemClickListener = { data ->
            startActivity(Intent(requireContext(), DetailActivity::class.java).also {
                it.putExtra(DetailActivity.DETAIL_KEY, data)
            })
        }

    }

    private fun observableInit() {
        viewModel.getAllFavoriteGame().observe(viewLifecycleOwner) {
            if (it == null) {
                binding.pbFavorite.visibility = View.GONE
                binding.textEmptyIndicator.visibility = View.VISIBLE
            } else
                binding.pbFavorite.visibility = View.GONE
            binding.textEmptyIndicator.visibility = View.GONE
            adapters.setData(it)
        }

    }
}