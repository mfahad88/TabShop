package com.example.tabshop.data.model

data class Product(
    val productId: Int,
    val name: String,
    val categoryId: Int,
    val brand: String?,
    val unit: String?,
    val description: String?,
    val purchasePrice: Double,
    val sellingPrice: Double,
    val stockQuantity: Int = 0,
    val barcode: String?,
    val imagePath: String?
)