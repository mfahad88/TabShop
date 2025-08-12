package com.example.tabshop.data.model

data class SaleItem(
    val saleItemId: Int,
    val saleId: Int,
    val productId: Int,
    val quantity: Int,
    val sellingPrice: Double
)