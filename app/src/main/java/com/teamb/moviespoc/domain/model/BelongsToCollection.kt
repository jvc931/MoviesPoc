package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.BelongsToCollectionDto

data class BelongsToCollection(
    var id: Int? = null,
    var name: String? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null

)

fun BelongsToCollectionDto.toDomain() = BelongsToCollection(
    id, name, posterPath, backdropPath
)
