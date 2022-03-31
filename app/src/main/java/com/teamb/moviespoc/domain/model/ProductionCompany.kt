package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.ProductionCompanyDto

data class ProductionCompany(
    var id            : Int?    = null,
    var logoPath      : String? = null,
    var name          : String? = null,
    var originCountry : String? = null
)

fun ProductionCompanyDto.toDomain() = ProductionCompany(
    id, logoPath, name, originCountry
)
