package com.example.mybottomnavapp.ui.character

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mybottomnavapp.R
import com.example.mybottomnavapp.data.remote.ApiDetails
import com.example.mybottomnavapp.databinding.FragmentCharacterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterFragment : Fragment() {

    lateinit var binding: FragmentCharacterBinding
    var characterCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false)

        loadData()

        binding.btnNextCharacter.setOnClickListener {
            characterCount++
            loadData()
        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnListEpisodes.setOnClickListener {
            val intent = Intent(activity, CharacterActivity::class.java)
           // intent.putExtra("id_character", characterCount)
            intent.putExtra("id_character", 2)

            startActivity(intent)
        }
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {

            val result = ApiDetails.rickClient.getRickCharacter(characterCount)
            binding.tvList.text = result.name

            Glide
                .with(requireContext())
                .load(result.image)
                //.centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)
        }
    }

}