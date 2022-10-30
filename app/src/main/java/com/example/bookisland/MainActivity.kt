package com.example.bookisland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.serialization.json.JsonNull.content

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val SearchFragment: Fragment = SearchFragment()
        val CollectionsFragment: Fragment = CollectionsFragment()
        val SettingsFragment: Fragment = SettingsFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.search_fragment -> fragment = SearchFragment()
                R.id.collections_fragment -> fragment = CollectionsFragment
                R.id.settings_fragment -> fragment = SettingsFragment
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.search_fragment
    }
    private fun replaceFragment(BookFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, BookFragment)
        fragmentTransaction.commit()
    }
}