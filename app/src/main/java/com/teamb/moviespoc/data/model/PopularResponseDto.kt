package com.teamb.moviespoc.data.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.google.gson.annotations.SerializedName

data class PopularResponseDto (
    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<PopularMovieDto> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
        )