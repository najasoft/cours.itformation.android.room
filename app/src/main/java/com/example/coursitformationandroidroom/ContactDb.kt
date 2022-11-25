package com.example.coursitformationandroidroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(Contact::class)], version = 2, exportSchema = false)
abstract class ContactDb : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private var instance: ContactDb? = null
        fun getInstance(context: Context): ContactDb {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext, ContactDb::class.java,
                    "contactsDb"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance as ContactDb
        }
    }
}