package com.example.tmsproject.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmsproject.entities.LibraryItem
import com.example.tmsproject.entities.NoteItem
import com.example.tmsproject.entities.ShoppingListItem
import com.example.tmsproject.entities.ShoppingListNames


@Database(
    entities = [LibraryItem::class, NoteItem::class,
        ShoppingListItem::class, ShoppingListNames::class], version = 1
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