package com.example.navigasimvvm.ui.ViewModel

import androidx.lifecycle.ViewModel
import com.example.navigasimvvm.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState: StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>) {
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                nim = listDM[1],
                gender = listDM[2],
                alamat = listDM[3],
                nohp = listDM[4],
                email = listDM[5]
            )
        }
    }
}