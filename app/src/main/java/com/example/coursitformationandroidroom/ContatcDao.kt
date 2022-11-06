package com.example.coursitformationandroidroom

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface ContactDao {
    @Query("Select * from Contact")
    fun getContacts(): List<Contact>

    @Query("Select * from Contact where idContact=:idC")
    fun getContact(idC: Long): Contact

    @Insert(onConflict = IGNORE)
    fun addContact(contact: Contact): Long

    @Delete
    fun delContact(contact: Contact)

    @Update(onConflict = REPLACE)
    fun updateContact(contact: Contact)
}