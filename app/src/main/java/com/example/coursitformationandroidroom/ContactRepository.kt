package com.example.coursitformationandroidroom

import android.content.Context

class ContactRepository(context: Context) {

    private val contactDao = ContactDb.getInstance(context).contactDao()
    fun getContacts(): List<Contact> = contactDao.getContacts()
    fun addContact(c: Contact): Long = contactDao.addContact(c)
}