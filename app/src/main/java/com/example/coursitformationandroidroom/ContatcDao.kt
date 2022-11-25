package com.example.coursitformationandroidroom

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Query("Select * from Contact")
    fun getContacts(): Flow<List<Contact>>

    @Query("Select * from Contact where idContact=:idC")
    fun getContact(idC: Long): Contact

     @Insert(onConflict = IGNORE)
     suspend fun addContact(contact: Contact): Long

    @Delete
   suspend fun delContact(contact: Contact)

    @Update(onConflict = REPLACE)
   suspend fun updateContact(contact: Contact)
}