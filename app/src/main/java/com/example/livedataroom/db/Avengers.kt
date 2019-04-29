package com.example.livedataroom.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Avengers(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val desc: String
)