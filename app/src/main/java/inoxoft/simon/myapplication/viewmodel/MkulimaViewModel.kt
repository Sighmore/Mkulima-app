package inoxoft.simon.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inoxoft.simon.myapplication.model.Repository
import inoxoft.simon.myapplication.model.TeaRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class MkulimaViewModel(private val repository: Repository): ViewModel() {



    fun upsertRecord(record: TeaRecord) { viewModelScope.launch {
        repository.upsertRecord(record)
    }
    }
    fun deleteRecord(record: TeaRecord) { viewModelScope.launch {
        repository.deleteRecord(record)
    }
    }
    fun getAllRecords(): Flow<List<TeaRecord>> {
        return repository.getAllRecords()
    }
    fun getTotalKilos(): Int {
        return repository.getTotalKilos()
    }

    var farmerName = mutableStateOf("")


            fun setFarmerName(name: String) {
                farmerName.value = name
            }

    var totalKilos = mutableStateOf("0.0")

    fun setTotalKilos(kilos: String) {
        totalKilos.value = kilos
    }




}