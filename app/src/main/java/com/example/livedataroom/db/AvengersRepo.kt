package com.example.livedataroom.db

import android.app.Application

class AvengersRepo(application: Application) {

    private val avengersDao = AppDb.getAppDb(application)?.avengersDao()

    private val avengers = avengersDao?.getAllAvengers()

    fun getAllAvengers() = avengers

    fun insertAvenger(avenger: Avengers) {
        avengersDao?.insertAvenger(avenger)
    }
}