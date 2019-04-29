package com.example.livedataroom.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.livedataroom.db.Avengers
import com.example.livedataroom.db.AvengersRepo

class AvengersViewModel(application: Application): AndroidViewModel(application) {

    private val avengersRepo = AvengersRepo(application)

    private val avengers = avengersRepo.getAllAvengers()

    fun getAvengers() = avengers

    fun insertAvenger(avenger: Avengers) {
        avengersRepo.insertAvenger(avenger)
    }
}