package com.example.coursitformationandroidroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.coursitformationandroidroom.ui.theme.CoursitformationandroidroomTheme

class MainActivity : ComponentActivity() {
     lateinit var repContacts:ContactRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repContacts = ContactRepository(this.applicationContext)
        if (repContacts.getContacts().size < 1)
        {
            repContacts.addContact(Contact(nom="Contact 1"))
            repContacts.addContact(Contact(nom="Contact 2"))
            repContacts.addContact(Contact(nom="Contact 3"))
            repContacts.addContact(Contact(nom="Contact 4"))
            repContacts.addContact(Contact(nom="Contact 5"))

        }
        setContent {
            CoursitformationandroidroomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(repContacts.getContacts())
                }
            }
        }
    }
}

@Composable
fun Greeting(liste:List<Contact>) {
    LazyColumn{
    //Entête de la liste
    item(){
    Text(text = "Liste des contacts", fontSize = 24.sp) }
        // Liste des contacts
        items(liste) {
            elt -> Row{
                Text(elt.nom)
        }
        }
    }
}

