package inoxoft.simon.myapplication.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MkulimaDao {

    @Upsert
    suspend fun upsertRecord(record: TeaRecord)

    @Delete
    suspend fun deleteRecord(record: TeaRecord)

    @Query("SELECT * FROM tearecord")
     fun getAllRecords() : Flow<List<TeaRecord>>

     @Query("SELECT totalKilos FROM teaRecord")
     fun getTotalKilos(): Int
}