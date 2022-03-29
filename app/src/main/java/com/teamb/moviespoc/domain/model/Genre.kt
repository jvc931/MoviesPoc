package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.GenresDto

data class Genre(
    var id   : Int?    = null,
    var name : String? = null
)

fun GenresDto.toDomain() = Genre(
    id, name
)
