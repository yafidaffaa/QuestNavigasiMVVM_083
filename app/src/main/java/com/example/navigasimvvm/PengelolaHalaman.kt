package com.example.navigasimvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasimvvm.model.DataJenisKelamin
import com.example.navigasimvvm.ui.View.DetailMahasiswaView
import com.example.navigasimvvm.ui.View.FormMahasiswaView
import com.example.navigasimvvm.ui.ViewModel.MahasiswaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

enum class Halaman {
    Formulir,
    Detail
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController(),


) {
    val StateUI by viewModel.uiState.collectAsState()

    NavHost(
        modifier = modifier.padding(8.dp),
        navController = navHost,
        startDestination = Halaman.Formulir.name
    ) {
        composable(route = Halaman.Formulir.name) {
            val konteks = LocalContext.current
            FormMahasiswaView(
                listJK = DataJenisKelamin.listJK.map { id ->
                    konteks.resources.getString(id)
                },
                onSubmitClicked = { dataMhs: MutableList<String> ->
                    viewModel.saveDataMahasiswa(dataMhs)
                    navHost.navigate(Halaman.Detail.name)
                }
            )
        }
        composable(route = Halaman.Detail.name) {
            DetailMahasiswaView(
                uiStateMahasiswa = StateUI,
                onBackButtonClicked = {
                    navHost.popBackStack()
                }
            )
        }
    }
}