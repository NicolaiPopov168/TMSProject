package com.example.tmsproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tmsproject.R
import com.example.tmsproject.databinding.ActivityMainBinding
import com.example.tmsproject.dialogs.NewListDialog
import com.example.tmsproject.fragments.FragmentManager
import com.example.tmsproject.fragments.NoteFragment
import com.example.tmsproject.fragments.ShopListNamesFragment

class MainActivity : AppCompatActivity(), NewListDialog.Listener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentManager.serFragment(ShopListNamesFragment.newInstance(), this)
        setBottomNavListener()
    }

    private fun setBottomNavListener() {
        binding.bNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {
                    Log.d("MyLog", "Settings")
                }
                R.id.notes -> {
                    FragmentManager.serFragment(NoteFragment.newInstance(), this)
                }
                R.id.shop_list -> {
                    FragmentManager.serFragment(ShopListNamesFragment.newInstance(), this)
                }
                R.id.new_item -> {
                    FragmentManager.currentFrag?.onClickNew()

                }
            }
            true
        }
    }

    override fun onCLick(name: String) {
        Log.d("MyLog", "Name: $name")
    }
}