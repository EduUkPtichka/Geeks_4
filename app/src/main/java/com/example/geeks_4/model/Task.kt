package com.example.geeks_4.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey
    val uid: Int? = null,
    val title: String? = null,
    val desc: String? = null
):Serializable
