package com.example.bookisland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val SearchFragment: Fragment = SearchFragment()
        val CollectionsFragment: Fragment = CollectionsFragment()

    }
}