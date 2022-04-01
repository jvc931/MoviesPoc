package com.teamb.moviespoc.ui.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <T> T.asFlow(): Flow<T> {
    return flow { emit(this@asFlow) }
}