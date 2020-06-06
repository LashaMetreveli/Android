package com.example.application

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDAO {

    @Query("SELECT * FROM itemmodel")
    fun getAll(): List<ItemModel>

    @Insert
    fun insertAll(vararg users: ItemModel)

    @Delete
    fun delete(item : ItemModel)

    @Query("UPDATE itemmodel SET description = :updatedDescription WHERE title = :title")
    fun update(title: String, updatedDescription: String)
}