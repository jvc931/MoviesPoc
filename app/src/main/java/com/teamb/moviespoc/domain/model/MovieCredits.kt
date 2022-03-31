package com.teamb.moviespoc.domain.model

import com.teamb.moviespoc.data.model.MovieCreditsDto

data class MovieCredits(
    var id   : Int?            = null,
    var cast : ArrayList<Cast> = arrayListOf(),
    var crew : ArrayList<Crew> = arrayListOf()
)

fun MovieCreditsDto.toDomain()= MovieCredits(
    id,
    cast.map { it.toDomain() } as ArrayList<Cast>,
    crew.map { it.toDomain() } as ArrayList<Crew>
)
