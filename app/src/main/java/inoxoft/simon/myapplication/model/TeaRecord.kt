package inoxoft.simon.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TeaRecord(
    var pluckerName: String,
    var pluckerAmount: Int,
    var pluckerKilo: Int,
    var totalKilos: Int,
    var date: String,

    @PrimaryKey(autoGenerate = true)
    var pluckerId: Int
)
