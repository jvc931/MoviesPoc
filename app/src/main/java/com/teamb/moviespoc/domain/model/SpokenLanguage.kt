package com.teamb.moviespoc.domain.model
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.SpokenLanguageDto

data class SpokenLanguage(
    var englishName : String? = null,
    var iso6391     : String? = null,
    var name        : String? = null
)

fun SpokenLanguageDto.toDomain() = SpokenLanguage(
    englishName, iso6391, name
)
