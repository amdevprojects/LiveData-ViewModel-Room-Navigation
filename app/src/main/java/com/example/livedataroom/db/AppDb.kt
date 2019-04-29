package com.example.livedataroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Avengers::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {

    abstract fun avengersDao(): AvengersDao

    companion object {

        private var INSTANCE: AppDb? = null

        fun getAppDb(context: Context): AppDb? {
            if (INSTANCE == null) {
                synchronized(AppDb::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDb::class.java, "appDb").build()
                }
            }
            return INSTANCE
        }
    }

}