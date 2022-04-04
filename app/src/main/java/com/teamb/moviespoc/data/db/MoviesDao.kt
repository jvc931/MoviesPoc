package com.teamb.moviespoc.data.db

import androidx.room.*
import com.teamb.moviespoc.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    /** Get favorite movies from local DB */
    @Query("Select * from PopularMovie")
    fun getSavedMovies() : Flow<List<PopularMovie>>

    /**
     * Save a popular movie to database
     * @param movie instance of movie to be saved
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: PopularMovie)

    /**
     * Delete movie from DB
     * */
    @Delete
    suspend fun delete(vararg movie: PopularMovie)
}