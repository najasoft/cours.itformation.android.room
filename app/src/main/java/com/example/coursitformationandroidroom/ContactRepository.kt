package com.example.coursitformationandroidroom

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContactRepository {

    // Portée des coroutines
  private  val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val contactDao =
        ContactDb.getInstance(ContactApplication.getContext()).contactDao()


    fun getContacts(): Flow<List<Contact>> = contactDao.getContacts()
    suspend fun addContact(c: Contact) =
        coroutineScope.launch(Dispatchers.IO) { contactDao.addContact(c) }

    suspend fun delContact(c: Contact) =
        coroutineScope.launch(Dispatchers.IO) { contactDao.delContact(c) }

    suspend fun updateContact(c: Contact) =
        coroutineScope.launch(Dispatchers.IO) { contactDao.updateContact(c) }
}