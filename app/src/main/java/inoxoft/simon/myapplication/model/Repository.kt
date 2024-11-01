package inoxoft.simon.myapplication.model

import kotlinx.coroutines.flow.Flow


class Repository(private val db: TeaDatabase) {
    suspend fun upsertRecord(record: TeaRecord) {
        db.dao.upsertRecord(record)
    }
    suspend fun deleteRecord(record: TeaRecord) {
        db.dao.deleteRecord(record)
    }
    fun getAllRecords(): Flow<List<TeaRecord>> {
        return db.dao.getAllRecords()
    }
    fun getTotalKilos(): Int {
        return db.dao.getTotalKilos()
    }

}