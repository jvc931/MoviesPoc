package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.*

data class MovieDetail(
    var adult: Boolean? = null,
    var backdropPath: String? = null,
    var belongsToCollection: BelongsToCollection? = BelongsToCollection(),
    var budget: Int? = null,
    var genres: ArrayList<Genre> = arrayListOf(),
    var homepage: String? = null,
    var id: Int? = null,
    var imdbId: String? = null,
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var productionCompanies: ArrayList<ProductionCompany> = arrayListOf(),
    var productionCountries: ArrayList<ProductionCountry> = arrayListOf(),
    var releaseDate: String? = null,
    var revenue: Int? = null,
    var runtime: Int? = null,
    var spokenLanguages: ArrayList<SpokenLanguage> = arrayListOf(),
    var status: String? = null,
    var tagline: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
)

fun MovieDetailDto.toDomain() = MovieDetail(
    adult,
    backdropPath,
    belongsToCollectionDto?.toDomain(),
    budget,
    genres.map { it.toDomain() } as ArrayList<Genre>,
    homepage,
    id,
    imdbId,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    productionCompanies.map { it.toDomain() } as ArrayList<ProductionCompany>,
    productionCountries.map { it.toDomain() } as ArrayList<ProductionCountry>,
    releaseDate,
    revenue,
    runtime,
    spokenLanguages.map { it.toDomain() } as ArrayList<SpokenLanguage>,
    status, tagline, title, video, voteAverage, voteCount
)
