package taufiq.apps.emgas.favgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.EntryPointAccessors
import taufiq.apps.core.di.FavoriteModuleDependencies
import taufiq.apps.emgas.DetailActivity
import taufiq.apps.emgas.favgame.databinding.FragmentFavoriteBinding
import taufiq.apps.emgas.favgame.di.DaggerFavoriteComponent
import javax.inject.Inject


/**
 * Created By Taufiq on 5/19/2021.
 *
 */
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    @Inject
    lateinit var factory: FavoriteViewModelFactory
    private val viewModel by viewModels<FavoriteViewModel> { factory }
    private val binding by viewBinding<FragmentFavoriteBinding >()

    private val adapters by lazy {
        FavAdapters(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)


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
            if (it.isNotEmpty()) {
                binding.pbFavorite.visibility = View.GONE
                binding.textEmptyIndicator.visibility = View.GONE
                binding.favRecyclerview.visibility = View.VISIBLE
                adapters.setData(it)
            } else {
                binding.pbFavorite.visibility = View.GONE
                binding.textEmptyIndicator.visibility = View.VISIBLE
                binding.favRecyclerview.visibility = View.GONE
            }

        }

    }


}