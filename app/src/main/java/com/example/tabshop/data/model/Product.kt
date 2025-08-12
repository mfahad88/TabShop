package com.example.tabshop.data.model

data class Product(
    val id: Int = 0,
    val sku: String? = null,
    val name: String,
    val sellingPrice: Double,
    val stockQuantity: Double = 0.0,
    val reorderLevel: Double = 0.0,
    val expiryDate: String? = null, // YYYY-MM-DD, nullable for non-perishables
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)