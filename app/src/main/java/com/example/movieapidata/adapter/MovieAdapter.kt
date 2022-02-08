package com.example.movieapidata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapidata.databinding.MovieItemsBinding
import com.example.movieapidata.model.response.Movie

class MovieAdapter(private val movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
//    Passes viewgroup to the viewholder and then creates a custom instance of a viewholder for the adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder.newInstance(parent)

//    Passes custom view holder to access its values
//    and then sets certain attributes based on the position relative to viewholder and the list
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.title.text = movies[position].Title
        holder.displayPoster(movies[position].Poster)
    }

//    Is utilized to know the bounds of the list being observed
    override fun getItemCount() = movies.size

    class MovieViewHolder(private val binding: MovieItemsBinding): RecyclerView.ViewHolder(binding.root) {

//        Viewholder attributes set to a similar binding attribute to connect dataloaded to XML
        var title = binding.title

//        Utilizes glide module to load a valid image url string to an actual rendered image
        fun displayPoster(jpg: String) {
            Glide.with(binding.root).load(jpg).into(binding.poster)
        }

//        Helper function to inflate the view holder and create the object in the adapter
        companion object {
            fun newInstance(parent: ViewGroup) = MovieItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).let { MovieViewHolder(it) }
        }
    }
}