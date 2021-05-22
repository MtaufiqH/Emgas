package taufiq.apps.emgas.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.core.data.Resource
import taufiq.apps.emgas.DetailActivity
import taufiq.apps.emgas.R
import taufiq.apps.emgas.adapter.GameAdapters
import taufiq.apps.emgas.databinding.FragmentGameBinding
import taufiq.apps.emgas.viewmodels.GameViewModels

/**
 * Created By Taufiq on 5/19/2021.
 *
 */
@AndroidEntryPoint
class GameFragment : Fragment(R.layout.fragment_game) {

    private val modelsGame by viewModels<GameViewModels>()
    private val binding: FragmentGameBinding by viewBinding()

    private val adapter by lazy {
        GameAdapters(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observableInit()
    }


    private fun initView() {
        binding.recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        adapter.itemClickListener = { data ->
            startActivity(Intent(requireContext(), DetailActivity::class.java).also {
                it.putExtra(DetailActivity.DETAIL_KEY, data)
            })
        }
    }

    private fun observableInit() {
        modelsGame.getDataGame().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.pbGame.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.pbGame.visibility = View.GONE
                    adapter.setData(it.data)
                }

                is Resource.Error -> {
                    binding.pbGame.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}