package com.teamb.moviespoc.data.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.google.gson.annotations.SerializedName

data class BelongsToCollectionDto(
    @SerializedName("id"            ) var id           : Int?    = null,
    @SerializedName("name"          ) var name         : String? = null,
    @SerializedName("poster_path"   ) var posterPath   : String? = null,
    @SerializedName("backdrop_path" ) var backdropPath : String? = null
)
