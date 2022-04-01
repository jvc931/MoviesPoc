package com.teamb.moviespoc.data.model

import com.google.gson.annotations.SerializedName

data class MovieCreditsDto(
    @SerializedName("id"   ) var id   : Int?            = null,
    @SerializedName("cast" ) var cast : ArrayList<CastDto> = arrayListOf(),
    @SerializedName("crew" ) var crew : ArrayList<CrewDto> = arrayListOf()
)
