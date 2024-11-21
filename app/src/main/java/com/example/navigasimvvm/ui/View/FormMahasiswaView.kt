package com.example.navigasimvvm.ui.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
) {
    var name by rememberSaveable { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by rememberSaveable { mutableStateOf("") }
    var selectedGender by rememberSaveable { mutableStateOf("") }

    val dataMahasiswa : MutableList<String> = mutableListOf(name, selectedGender, alamat)


    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp)
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            placeholder = { Text("Masukan Nama") },
            label = { Text("Nama") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )

        Row {
            listJK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    RadioButton(selected = selectedGender==item, onClick = {
                        selectedGender = item
                    })
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukan email") },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukan alamat") },
            label = { Text("alamat") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )
        OutlinedTextField(
            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukan no HP") },
            label = { Text("no HP") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)

        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            onSubmitClicked(dataMahasiswa)
        }) {
            Text(text = "Save")
        }
    }
}