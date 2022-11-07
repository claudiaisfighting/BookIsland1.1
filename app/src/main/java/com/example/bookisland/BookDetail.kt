package com.example.bookisland

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.text.method.ScrollingMovementMethod

class BookDetail: AppCompatActivity() {
    private lateinit var BookTitle: TextView
    private lateinit var BookAuthors: TextView
    private lateinit var BookImage: ImageView
    private lateinit var BookDescription: TextView
    private lateinit var BookPrice: TextView
    private lateinit var BookSaleability: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_detail)
        BookAuthors= findViewById(R.id.authors)
        BookPrice = findViewById(R.id.price)
        BookTitle = findViewById(R.id.BookTitle)
        BookImage = findViewById(R.id.BookImage)
        BookDescription = findViewById(R.id.Description)
        BookSaleability = findViewById(R.id.saleability)

        var bundle = intent.extras
        val book = bundle?.getSerializable("value") as Book
        //val book = intent.getSerializableExtra("Book Details") as Book

        BookPrice.text = "Price: " + book.price.toString() + "USD"
        BookTitle.text = "Title: " + book.title
        BookDescription.text = book.description
        BookSaleability.text = "Availability: " + book.saleability
        BookAuthors.text = "Authors: " + book.authors
        BookDescription.movementMethod = ScrollingMovementMethod()
        Glide.with(this)
            .load(book.thumbnail)
            .centerInside()
            .into(BookImage)
    }

}

