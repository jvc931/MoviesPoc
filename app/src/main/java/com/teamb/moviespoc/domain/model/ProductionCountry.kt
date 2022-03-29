package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.ProductionCountryDto

data class ProductionCountry(
    var iso31661 : String? = null,
    var name     : String? = null
)

fun ProductionCountryDto.toDomain() = ProductionCountry(
    iso31661, name
)
