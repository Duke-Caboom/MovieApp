package com.tmbd.themovieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tmbd.movieapp.databinding.MovieListItemBinding
import com.tmbd.movieapp.ui.view.HomeFragment
import com.tmbd.themovieapp.data.models.MovieModel

class MovieListAdapter(
    private val homeFragment: HomeFragment,
    private val listMovie: List<MovieModel>
): RecyclerView.Adapter<MovieListAdapter.MovieHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(homeFragment, MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.render(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieHolder(private val homeFragment: HomeFragment?,private val binding: MovieListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun render(movie: MovieModel){
            binding.textTitleItem.text = movie.title
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movie.poster_path).into(binding.movieImg)
            binding.cardView.setOnClickListener(View.OnClickListener {
                homeFragment?.listener?.onClickFragmentButton(movie)
            })
        }
    }
}