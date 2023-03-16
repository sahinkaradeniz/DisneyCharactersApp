package com.example.disneycharactersapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.databinding.FragmentHomeBinding
import com.example.disneycharactersapp.ui.detail.DetailUiData
import com.example.disneycharactersapp.util.SearchTextWatcher
import com.example.disneycharactersapp.util.hide
import com.example.disneycharactersapp.util.show
import com.example.disneycharactersapp.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy { HomeAdapter(::clickItem) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewState()
        viewModel.getDisneyCharacters()
        binding.searchEditText.addTextChangedListener(
            SearchTextWatcher{
                if (it.isBlank()){
                    viewModel.getDisneyCharacters()
                }else{
                    viewModel.searchDisneyCharacters(it)
                }
            }
        )
    }



    private fun viewState() {
        viewModel.disneyHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), "eror", Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Success -> {
                    handleUiState(it.data)
                    binding.homeRcv.adapter = adapter
                    binding.homeRcv.layoutManager = GridLayoutManager(requireContext(), 2)
                    progressHide()
                }
                is HomeUiState.Loading -> {
                    progressShow()
                }
            }
        }
    }

    private fun clickItem(i: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(i)
        findNavController().navigate(action)
    }

    private fun handleUiState(data: List<HomeUiData>) {
        adapter.updateItems(data)
    }

    private fun progressShow() {
        binding.homeRcv.hide()
        binding.progressBar.show()
    }

    private fun progressHide() {
        binding.homeRcv.show()
        binding.progressBar.hide()
    }


}