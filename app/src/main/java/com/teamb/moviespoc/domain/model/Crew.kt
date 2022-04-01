package com.teamb.moviespoc.domain.model

import com.teamb.moviespoc.data.model.CrewDto

data class Crew(
    var adult: Boolean? = null,
    var gender: Int? = null,
    var id: Int? = null,
    var knownForDepartment: String? = null,
    var name: String? = null,
    var originalName: String? = null,
    var popularity: Double? = null,
    var profilePath: String? = null,
    var creditId: String? = null,
    var department: String? = null,
    var job: String? = null
)

fun CrewDto.toDomain() = Crew(
    adult,
    gender,
    id,
    knownForDepartment,
    name,
    originalName,
    popularity,
    profilePath,
    creditId,
    department,
    job
)