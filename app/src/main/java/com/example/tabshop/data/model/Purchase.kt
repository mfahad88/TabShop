package com.example.tabshop.data.model

data class Purchase(
    val id: Int = 0,
    val supplierId: Int? = null,
    val purchaseDate: String, // YYYY-MM-DD
    val totalAmount: Double,
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)