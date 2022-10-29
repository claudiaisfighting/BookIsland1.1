package com.example.bookisland

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

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

        val movie = intent.getSerializableExtra("Book Details") as BookEntity

        MoviePopularity.text = "Popularity: " + movie.popularity.toString()
        MovieReleaseDate.text = "Release Date: " + movie.release_date
        MovieTitle.text = movie.title
        MovieOverview.text = movie.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
            .centerInside()
            .into(MovieImage)
    }
}
}