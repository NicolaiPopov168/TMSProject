package com.example.tmsproject.fragments

import androidx.appcompat.app.AppCompatActivity
import com.example.tmsproject.R

object FragmentManager {

    var currentFrag: BaseFragment? = null

    fun serFragment(newFrag: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFrag)
        transaction.commit()
        currentFrag = newFrag
    }
}