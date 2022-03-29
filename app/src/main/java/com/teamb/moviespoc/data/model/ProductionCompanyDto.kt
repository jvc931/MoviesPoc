package com.teamb.moviespoc.data.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.google.gson.annotations.SerializedName

data class ProductionCompanyDto(
    @SerializedName("id"             ) var id            : Int?    = null,
    @SerializedName("logo_path"      ) var logoPath      : String? = null,
    @SerializedName("name"           ) var name          : String? = null,
    @SerializedName("origin_country" ) var originCountry : String? = null
)
