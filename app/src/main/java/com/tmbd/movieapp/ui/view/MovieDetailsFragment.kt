package com.tmbd.movieapp.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.squareup.picasso.Picasso
import com.tmbd.movieapp.databinding.MovieDetailsFragmentBinding
import com.tmbd.movieapp.ui.viewmodel.MovieDetailsViewModel

class MovieDetailsFragment : Fragment() {
    
    private lateinit var viewModel: MovieDetailsViewModel
    private var _binding: MovieDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var youTubePlayerView : YouTubePlayerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        viewModel.onCreate(this.activity?.intent?.getIntExtra("idMovie", -1))
        createObserver(this)
        init()
        youTubePlayerView= binding.youtubeView
        getLifecycle().addObserver(youTubePlayerView)

        return binding.root
    }

    private fun createObserver(movieDetailsFragment: MovieDetailsFragment) {
        viewModel._mediaForMovie.observe(movieDetailsFragment.viewLifecycleOwner,{
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(it.key, 0.0f)
                }
            })
        })
    }

    private fun init(){
        binding.textViewTitleDetails.text = this.activity?.intent?.getStringExtra("title")
        binding.textViewDescDetails.text= this.activity?.intent?.getStringExtra("overview")
        binding.ratingBarDetails.rating=
            (this.activity?.intent?.getFloatExtra("vote_average", 0.0f))?.div(2) ?:0.0f
        Picasso.get().load(this.activity?.intent?.getStringExtra("poster_path")).into(binding.imageViewDetails )
    }

}