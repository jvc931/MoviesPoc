package com.teamb.moviespoc.data.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.google.gson.annotations.SerializedName

data class ProductionCountryDto(
    @SerializedName("iso_3166_1" ) var iso31661 : String? = null,
    @SerializedName("name"       ) var name     : String? = null
)
