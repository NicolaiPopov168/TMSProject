package com.example.tmsproject.activity

import android.app.Application
import com.example.tmsproject.dataBase.MainDataBase

class MainApp: Application() {
    val database by lazy { MainDataBase.getDataBase(this) }
}