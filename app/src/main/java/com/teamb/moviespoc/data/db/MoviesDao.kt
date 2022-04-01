package com.teamb.moviespoc.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.teamb.moviespoc.domain.model.PopularMovie

@Dao
interface MoviesDao {
    /** Get favorite movies from local DB */
    @Query("Select * from PopularMovie")
    fun getSavedMovies() : LiveData<List<PopularMovie>>

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