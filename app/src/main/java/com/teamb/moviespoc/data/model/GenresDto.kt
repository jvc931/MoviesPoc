package com.teamb.moviespoc.data.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.google.gson.annotations.SerializedName

data class GenresDto(
    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null
)
