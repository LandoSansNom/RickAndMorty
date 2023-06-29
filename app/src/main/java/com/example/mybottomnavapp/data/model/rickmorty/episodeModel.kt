package com.example.mybottomnavapp.data.model.rickmorty

import com.google.gson.annotations.SerializedName

data class episodeModel(

    @SerializedName("id")
    val id_episode: Int = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("air_date")
    val air_date: String = ""


)
