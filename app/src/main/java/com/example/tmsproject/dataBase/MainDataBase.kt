package com.example.tmsproject.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmsproject.entities.LibraryItem
import com.example.tmsproject.entities.NoteItem
import com.example.tmsproject.entities.ShopListItem
import com.example.tmsproject.entities.ShopListNameItem


@Database(
    entities = [LibraryItem::class, NoteItem::class,
        ShopListItem::class, ShopListNameItem::class], version = 1
)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.db"
                ).build()
                instance
            }
        }
    }
}