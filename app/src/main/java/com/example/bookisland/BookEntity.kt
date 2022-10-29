package com.example.bookisland

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
 data class BookEntity (
  @SerialName("title")
  var title: String?,
  @SerialName("authors[]")
  var authors: List<String>?,
  @SerialName("description")
  var description: String?,
  @SerialName("imagelinks.medium")
  var image_link: String?,
  @SerialName("saleability")
  var saleability: String?,
  @SerialName("amount")
  var price: Double?, ) : java.io.Serializable
{}