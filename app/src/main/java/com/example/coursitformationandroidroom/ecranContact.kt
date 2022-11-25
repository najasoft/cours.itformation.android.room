package com.example.coursitformationandroidroom


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.collectAsState


import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel


@Composable
fun EcranContacts() {
    val vm = ContactViewModel()


    val liste = vm.getContacts().collectAsState(emptyList()).value
    val textState = remember { mutableStateOf("") }
    val textStateId = remember { mutableStateOf(0L) }
    val selectedContact= remember { mutableStateOf(-1L) }

    LazyColumn {
        item {
            Column {
                Row {

                    TextField(value = textStateId.value.toString(),
                        onValueChange = { v -> textStateId.value = v.toLong() },
                        label = { Text("Id")
                        },
                        modifier=    Modifier.weight(0.15f)
                    )

                    TextField(value = textState.value,
                        onValueChange = { v -> textState.value = v },
                        label = { Text("Nom") }
                    )
                    Button(onClick = { vm.addContact(Contact(nom = textState.value)) },
                        modifier=Modifier.weight(0.15f)) {
                        Text("Add")
                    }
                }
                Row {
                    val i = liste.size ?: 0
                    Text("Liste des contacts:$i", fontSize = 24.sp)
                }
            }
        }

            items(liste) { c -> Row( modifier=Modifier.selectable(
                selected = selectedContact.value==c.idContact,
                onClick = {
                    selectedContact.value=c.idContact
                    textState.value=c.nom
                    textStateId.value=c.idContact
                }
            )) {
                LigneContact(c, vm)
            }

            }

    }


}


@Composable
fun LigneContact(c: Contact,vm:ContactViewModel) {

    Row {
        Text(c.idContact.toString(),
            modifier=Modifier.weight(0.15f))
        Text(c.nom,
            modifier=Modifier.weight(0.70f))
        Button(onClick = { vm.delContact(c) },
            modifier=Modifier.weight(0.15f)) {
            Text("Del")
        }
    }
}