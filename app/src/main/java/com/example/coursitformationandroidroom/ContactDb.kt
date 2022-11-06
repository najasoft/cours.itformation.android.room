package com.example.coursitformationandroidroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(Contact::class)], version = 2)
abstract class ContactDb : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        var instance: ContactDb? = null
        fun getInstance(context: Context): ContactDb {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, ContactDb::class.java,
                    "contactsDb"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as ContactDb
        }
    }
}