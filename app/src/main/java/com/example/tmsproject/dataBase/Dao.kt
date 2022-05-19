package com.example.tmsproject.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tmsproject.entities.ShopListNameItem
import com.example.tmsproject.entities.ShopListItem
import kotlinx.coroutines.flow.Flow
import com.example.tmsproject.entities.NoteItem as NoteItem

@Dao
interface Dao {
    //почитать команды sqlLite
    @Query("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItem>>

    @Query("SELECT * FROM shopping_list_names")
    fun getAllShopListNames(): Flow<List<ShopListNameItem>>

    @Query("DELETE FROM note_list WHERE id IS :id")
    suspend fun deleteNote(id: Int)

    @Query("DELETE FROM shopping_list_names WHERE id IS :id")
    suspend fun deleteShopListName(id: Int)

    @Insert
    suspend fun insertNote(note: NoteItem)

    @Insert
    suspend fun insertItem(note: ShopListItem)

    @Insert
    suspend fun insertShopListName(shopListNameItem: ShopListNameItem)

    @Update
    suspend fun updateNote(note: NoteItem)

    @Update
    suspend fun updateListName(shopListName: ShopListNameItem)
}