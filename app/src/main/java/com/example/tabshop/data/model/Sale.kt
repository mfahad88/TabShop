package com.example.tabshop.data.model

data class Sale(
    val id: Int = 0,
    val customerId: Int? = null,
    val saleDate: String, // YYYY-MM-DD
    val totalAmount: Double,
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)
