package com.example.tmsproject.dataBase

import androidx.lifecycle.*
import com.example.tmsproject.entities.NoteItem
import com.example.tmsproject.entities.ShopListItem
import com.example.tmsproject.entities.ShopListNameItem
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(dataBase: MainDataBase): ViewModel() {

    val dao = dataBase.getDao()
    val allNotes: LiveData<List<NoteItem>> = dao.getAllNotes().asLiveData()
    val allShopListNamesItem: LiveData<List<ShopListNameItem>> = dao.getAllShopListNames().asLiveData()

    fun insertNote(note: NoteItem) = viewModelScope.launch {
        dao.insertNote(note)
    }

    fun insertShopListName(listName: ShopListNameItem) = viewModelScope.launch {
        dao.insertShopListName(listName)
    }

    fun insertShopItem(shopListItem: ShopListItem) = viewModelScope.launch {
        dao.insertItem(shopListItem)
    }

    fun updateNote(note: NoteItem) = viewModelScope.launch {
        dao.updateNote(note)
    }

    fun updateListName(shopListName: ShopListNameItem) = viewModelScope.launch {
        dao.updateListName(shopListName)
    }

    fun deleteNote(id: Int) = viewModelScope.launch {
        dao.deleteNote(id)
    }

    fun deleteShopListName(id: Int) = viewModelScope.launch {
        dao.deleteShopListName(id)
    }

    class MainViewModelFactory(val dataBase: MainDataBase): ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(dataBase) as T
            }
            throw  IllegalArgumentException("Unknown ViewModelClass")
        }
    }
}