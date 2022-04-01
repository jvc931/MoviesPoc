package com.teamb.moviespoc.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teamb.moviespoc.domain.model.PopularMovie

/* The Room database for this app */
@Database(entities = [PopularMovie::class],
    version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

}