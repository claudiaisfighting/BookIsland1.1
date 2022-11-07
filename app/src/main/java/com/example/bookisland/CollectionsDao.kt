package com.example.bookisland

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CollectionsDao {

    @Query("SELECT * FROM collection_table")
    fun getCollections() : Flow<List<CollectionEntity>>

    //@Query("SELECT * FROM profile_table")
    //fun getAll(): java.util.concurrent.Flow<List<Book>>

    @Insert
    fun insert(collection : CollectionEntity)

    @Query("DELETE FROM collection_table")
    fun deleteAll()
}