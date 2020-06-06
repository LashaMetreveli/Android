package com.example.application

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ItemModel::class), version = 1)
abstract class AppDB : RoomDatabase(){
    abstract fun  itemDAO(): ItemDAO
}