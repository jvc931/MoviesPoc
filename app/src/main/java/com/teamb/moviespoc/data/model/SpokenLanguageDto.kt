package com.teamb.moviespoc.data.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.google.gson.annotations.SerializedName

data class SpokenLanguageDto(
    @SerializedName("english_name" ) var englishName : String? = null,
    @SerializedName("iso_639_1"    ) var iso6391     : String? = null,
    @SerializedName("name"         ) var name        : String? = null
)
