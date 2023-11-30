package com.app.githubclient.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemEntity: ItemEntity)

    @Query("SELECT * FROM ItemEntity LIMIT 15")
    fun getAllItems() : List<ItemEntity>

    @Delete
    suspend fun deleteItem(item: ItemEntity)
}