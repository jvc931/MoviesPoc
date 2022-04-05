package com.teamb.moviespoc.domain.model

import com.teamb.moviespoc.data.model.CastDto

data class Cast(
    var adult: Boolean? = null,
    var gender: Int? = null,
    var id: Int? = null,
    var knownForDepartment: String? = null,
    var name: String? = null,
    var originalName: String? = null,
    var popularity: Double? = null,
    var profilePath: String? = null,
    var castId: Int? = null,
    var character: String? = null,
    var creditId: String? = null,
    var order: Int? = null
)

fun CastDto.toDomain() = Cast(
    adult,
    gender,
    id,
    knownForDepartment,
    name,
    originalName,
    popularity,
    profilePath,
    castId,
    character,
    creditId,
    order
)
