package inoxoft.simon.myapplication.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TeaRecord::class],version = 1)
abstract class TeaDatabase : RoomDatabase(){
    abstract val dao: MkulimaDao
}