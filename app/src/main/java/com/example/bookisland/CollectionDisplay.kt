package com.example.bookisland

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CollectionDisplay : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: CollectionDisplayRecycleAdapter
    private lateinit var collectionName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collection_display)
        collectionName = findViewById(R.id.collectionName)

        var collection = intent.getSerializableExtra("Collection") as BookCollection
        collectionName.text = collection.name
        recyclerView = findViewById(R.id.collection_display)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        bookAdapter = CollectionDisplayRecycleAdapter(this,collection.bookList!!)
        recyclerView.adapter = bookAdapter
    }
}