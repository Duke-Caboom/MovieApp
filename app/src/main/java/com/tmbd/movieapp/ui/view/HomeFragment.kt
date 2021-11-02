package com.tmbd.movieapp.ui.view

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmbd.movieapp.databinding.HomeFragmentBinding
import com.tmbd.movieapp.ui.inter.OnMovieClickListener
import com.tmbd.movieapp.ui.viewmodel.HomeViewModel
import com.tmbd.themovieapp.adapters.MovieListAdapter

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    var listener: OnMovieClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.onCreate()
        createObserver(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun createObserver(homeFragment: HomeFragment) {
        viewModel.isLoading.observe(homeFragment.viewLifecycleOwner, Observer {
            binding.progress.isVisible = it
        })

        viewModel._moviePlayingNowModel.observe(homeFragment.viewLifecycleOwner,{
            binding.recyclerViewPlayNow.setHasFixedSize(true)
            binding.recyclerViewPlayNow.layoutManager= LinearLayoutManager(homeFragment.context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewPlayNow.adapter = MovieListAdapter(homeFragment, it)
        })

        viewModel._movieMostPopularModel.observe(homeFragment.viewLifecycleOwner,{
            binding.recyclerViewMostPopular.setHasFixedSize(true)
            binding.recyclerViewMostPopular.layoutManager= LinearLayoutManager(homeFragment.context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerViewMostPopular.adapter = MovieListAdapter(homeFragment, it)
        })
    }

}