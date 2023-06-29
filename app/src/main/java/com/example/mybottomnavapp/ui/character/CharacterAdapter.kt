package com.example.mybottomnavapp.ui.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybottomnavapp.R
import com.example.mybottomnavapp.databinding.ItemEpisodeBinding

class CharacterAdapter(val episodes: List<String>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_episode,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        episodes[position]?.let { holder.UpdateUi(it) }
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemEpisodeBinding.bind(view)
        fun UpdateUi(episode: String){
            binding.apply {
                tvName.text = episode
            }
        }

    }

}