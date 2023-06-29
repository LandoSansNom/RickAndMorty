package com.example.mybottomnavapp.ui.character

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybottomnavapp.data.remote.ApiDetails
import com.example.mybottomnavapp.databinding.ActivityListEpisodesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterActivity : AppCompatActivity() {
    lateinit var binding: ActivityListEpisodesBinding
    var idCharacter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityListEpisodesBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // idCharacter = intent.getIntExtra("id_character",0)
        loadEpisodesByCharacterId(2)
    }


    private fun loadEpisodesByCharacterId(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            var episodes = ApiDetails.rickClient.getRickCharacter(id).episode
            Log.d("ebillson",episodes.toString())
            binding.rvEpisodes.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CharacterAdapter(episodes)
            }
        }
    }
}