package com.example.disneycharactersapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.databinding.FragmentHomeBinding
import com.example.disneycharactersapp.ui.base.BaseFragment
import com.example.disneycharactersapp.util.gone
import com.example.disneycharactersapp.util.setOnSearchListener
import com.example.disneycharactersapp.util.viewBinding
import com.example.disneycharactersapp.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

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
        if (viewModel.allDisneyCharacters.isNullOrEmpty()){
            viewModel.getDisneyCharacters()
        }
        binding.searchEditText.setOnSearchListener {
            if (it.isBlank()) {
                viewModel.getDisneyCharacters()
            } else {
                viewModel.searchDisneyCharacters(it)
            }
        }
        binding.homeRcv.adapter = adapter
        binding.homeRcv.layoutManager = GridLayoutManager(requireContext(), 2)
    }


    private fun viewState() {
        viewModel.disneyHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), "Eror", Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Success -> {
                    handleUiState(it.data)
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
        adapter.submitList(data)
    }

    private fun progressShow() {
        binding.root.gone()
        showProgress()
    }

    private fun progressHide() {
        binding.root.visible()
        hideProgress()
    }


}