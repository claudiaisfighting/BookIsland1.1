package com.example.bookisland

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollectionsAdapter(private val context: Context, private val collections: List<DisplayCollection>)
    : RecyclerView.Adapter<CollectionsAdapter.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.collections_item, parent, false)
            return ViewHolder(view)
        }
        override fun getItemCount() = collections.size

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener
        {

            private val name = itemView.findViewById<TextView>(R.id.collection_name)
            private val books = itemView.findViewById<TextView>(R.id.books)

            fun bind(collection: DisplayCollection) {
                name.text = collection.name
                books.text = collection.collection?.size.toString() + " Books"
            }

            override fun onClick(v: View?) {
                // TODO: Get selected article
                val collection = collections[absoluteAdapterPosition]
                // TODO: Navigate to Details screen and pass selected article
                val intent = Intent(context, CollectionDisplay::class.java)
                intent.putExtra("Collection", collection)
                context.startActivity(intent)
            }
        }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collections= collections[position]
        holder.bind(collections)
    }
    }

