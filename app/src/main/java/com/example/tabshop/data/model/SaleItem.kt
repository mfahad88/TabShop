package com.example.tabshop.data.model

data class SaleItem(
    val id: Int = 0,
    val saleId: Int,
    val productId: Int,
    val quantity: Double,
    val unitPrice: Double,
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)