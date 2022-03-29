package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.PopularMovieDto

data class PopularMovie(
    var adult: Boolean? = null,
    var backdropPath: String? = null,
    var genreIds: ArrayList<Int> = arrayListOf(),
    var id: Int? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null

)

fun PopularMovieDto.toDomain() = PopularMovie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)
