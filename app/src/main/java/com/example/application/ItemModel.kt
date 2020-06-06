package com.example.application

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
class ItemModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Int =0

    @ColumnInfo(name = "title")
    var title: String? = ""

    @ColumnInfo(name = "description")
    var description: String? = ""

}
