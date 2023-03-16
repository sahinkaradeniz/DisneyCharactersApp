package com.example.disneycharactersapp.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharactersapp.R
import com.example.disneycharactersapp.databinding.FragmentDetailBinding
import com.example.disneycharactersapp.util.hide
import com.example.disneycharactersapp.util.loadUrl
import com.example.disneycharactersapp.util.show
import com.example.disneycharactersapp.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private  val binding by viewBinding (FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
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
                    val adapter = DetailParentAdapter(
                        listOfNotNull(
                            it.data.films,
                            it.data.tvShows,
                            it.data.videoGames,
                            it.data.shortFilms
                        )
                    ,requireContext())
                    println(" data " + it.data.toString())
                    binding.detailRcv.adapter=adapter
                    binding.detailRcv.layoutManager=LinearLayoutManager(requireContext())
                 //   Toast.makeText(requireContext(), "succes", Toast.LENGTH_SHORT).show()
                }
                is DetailUiState.Error ->{
                    Log.e("view state","Data loading eror")
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
        binding.imageCharacter.loadUrl(data.imageUrl)
        binding.nameCharacter.text=data.name
    }


}