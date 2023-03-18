package com.example.disneycharactersapp.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.databinding.FragmentHomeBinding
import com.example.disneycharactersapp.ui.base.BaseFragment
import com.example.disneycharactersapp.util.SearchTextWatcher
import com.example.disneycharactersapp.util.gone
import com.example.disneycharactersapp.util.viewBinding
import com.example.disneycharactersapp.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy { HomeAdapter(::clickItem) }

    private val TAG = this::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Log.d(TAG, "onCreateView: HomeFragment")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: HomeFragment")
        binding.homeRcv.adapter = adapter
        binding.homeRcv.layoutManager = GridLayoutManager(requireContext(), 2)
        viewState()
        if (viewModel.allDisneyCharacters.isNullOrEmpty())
            viewModel.getDisneyCharacters()

        binding.searchEditText.setOnSearchListener {
            if (it.isBlank()) {
                viewModel.getDisneyCharacters()
            } else {
                viewModel.searchDisneyCharacters(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: HomeFragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: HomeFragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.disneyHomeUiState.removeObservers(viewLifecycleOwner)
        Log.d(TAG, "onDestroyView: HomeFragment")
    }

    private fun viewState() {
        viewModel.disneyHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), "eror", Toast.LENGTH_SHORT).show()
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
        binding.homeRcv.gone()
        binding.progressBar.visible()
    }

    private fun progressHide() {
        binding.homeRcv.visible()
        binding.progressBar.gone()
    }

    private fun EditText.setOnSearchListener(content: (String) -> Unit) {
        addTextChangedListener(
            SearchTextWatcher {
                if(this.hasFocus())
                    content(it)
            }
        )
    }

}