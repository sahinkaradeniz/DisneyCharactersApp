package com.example.disneycharactersapp.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.databinding.FragmentDetailBinding
import com.example.disneycharactersapp.util.downloadFromUrl
import com.example.disneycharactersapp.util.hide
import com.example.disneycharactersapp.util.show
import com.example.disneycharactersapp.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private  val binding by viewBinding (FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private val adapter by lazy { DetailParentAdapter(requireContext()) }

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
                   viewLoading()
                }
                is DetailUiState.Success ->{
                    viewSucces()
                    setDetailData(it.data)
                    println(" data " + it.data.toString())
                    adapter.updateItems(
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

    private fun viewLoading(){
        binding.progressBar2.show()
        binding.companentView.hide()
    }
    private fun viewSucces(){
        binding.progressBar2.hide()
        binding.companentView.show()
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