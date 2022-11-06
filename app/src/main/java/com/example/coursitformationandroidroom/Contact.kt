package com.example.coursitformationandroidroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true) var idContact: Long = 0L,
    @ColumnInfo(name = "nom_contact") val nom: String
) {

}

