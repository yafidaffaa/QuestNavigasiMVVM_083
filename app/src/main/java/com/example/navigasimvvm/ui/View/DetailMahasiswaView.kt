package com.example.navigasimvvm.ui.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigasimvvm.model.DataMahasiswa


@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onBackButtonClicked: () -> Unit
) {
    val listData = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("NIM", uiStateMahasiswa.nim),
        Pair("Jenis Kelamin", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
        Pair("No HP", uiStateMahasiswa.nohp),
        Pair("Email", uiStateMahasiswa.email)

    )

    Column {
        listData.forEach { item ->
            CardSection(
                judulParam = item.first,
                isiParam = item.second
            )
        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column (horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(top = 10.dp)) {


        Row (modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start

        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f).padding(start = 10.dp))
            Text(text = ":", modifier = Modifier.weight(0.2f).padding(start = 10.dp))
            Text(text = isiParam, modifier = Modifier.weight(2f).padding(start = 10.dp))
        }
    }
}