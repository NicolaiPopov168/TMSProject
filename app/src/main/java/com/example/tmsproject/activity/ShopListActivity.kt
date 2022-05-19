package com.example.tmsproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.tmsproject.R
import com.example.tmsproject.dataBase.MainViewModel
import com.example.tmsproject.databinding.ActivityShopListBinding
import com.example.tmsproject.entities.ShopListNameItem

class ShopListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShopListBinding
    private var shopListName: ShopListNameItem? = null
    private lateinit var saveItem: MenuItem

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shop_list_menu, menu)
        saveItem = menu?.findItem(R.id.ic_save_item)!!
        val newItem = menu.findItem(R.id.ic_new_item)
        newItem.setOnActionExpandListener(expandActionView())
        saveItem.isVisible = false
        return super.onCreateOptionsMenu(menu)
    }

    private fun expandActionView(): MenuItem.OnActionExpandListener {
        return object : MenuItem.OnActionExpandListener {

            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                saveItem.isVisible = true
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                saveItem.isVisible = false
                invalidateOptionsMenu()// рисуем меню заново
                return true
            }
        }
    }

    private fun init() {
        shopListName = intent.getSerializableExtra(SHOP_LIST_NAME) as ShopListNameItem
        binding.tvTest.text = shopListName?.name
    }

    companion object {
        const val SHOP_LIST_NAME = "SHOP_LIST_NAME"
    }
}