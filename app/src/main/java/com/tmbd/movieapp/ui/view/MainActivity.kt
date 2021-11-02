package com.tmbd.movieapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tmbd.movieapp.databinding.ActivityMainBinding
import com.tmbd.movieapp.ui.inter.OnMovieClickListener
import com.tmbd.themovieapp.data.models.MovieModel

class MainActivity : AppCompatActivity(),OnMovieClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClickFragmentButton(movie: MovieModel) {
        val intent: Intent = Intent(this, MovieDetailsActivity::class.java).apply {
            putExtra("idMovie", movie.id)
            putExtra("title", movie.title)
            putExtra("overview", movie.overview)
            putExtra("poster_path", "https://image.tmdb.org/t/p/w500/"+movie.poster_path)
            putExtra("vote_average", movie.vote_average)
        }
        this.startActivity(intent)
    }
}