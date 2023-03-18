package com.example.disneycharactersapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.databinding.FragmentDetailBinding
import com.example.disneycharactersapp.ui.base.BaseFragment
import com.example.disneycharactersapp.util.downloadFromUrl
import com.example.disneycharactersapp.util.gone
import com.example.disneycharactersapp.util.visible
import com.example.disneycharactersapp.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {
    private  val binding by viewBinding (FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private val adapter by lazy { DetailParentAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        back()
        getArgument()
        viewState()

    }

    private fun viewState(){
        viewModel.detailUiState.observe(viewLifecycleOwner){
            when(it){
                is DetailUiState.Loading ->{
                   progressShow()
                }
                is DetailUiState.Success ->{
                  progressGone()
                    setDetailData(it.data)
                    println(" data " + it.data.toString())
                    adapter.submitList(
                        listOfNotNull(
                            it.data.films,
                            it.data.tvShows,
                            it.data.videoGames,
                            it.data.shortFilms
                        )
                    )
                    binding.detailRcv.adapter=adapter
                    binding.detailRcv.layoutManager=LinearLayoutManager(requireContext())
                }
                is DetailUiState.Error ->{
                    Log.e("view state","Data loading eror, ${it.message}")
                }
            }
        }
    }


    private fun progressGone(){
       hideProgress()
        binding.root.visible()
    }
    private fun progressShow(){
        showProgress()
        binding.root.gone()
    }
    private fun back(){
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    private fun getArgument(){
        val id = args.id
        viewModel.getDisneyCharacter(id)
    }
    private fun setDetailData(data:DetailUiData){
        binding.imageCharacter.downloadFromUrl(data.imageUrl)
        binding.nameCharacter.text=data.name
    }


}