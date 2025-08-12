package com.example.tabshop.data.model

data class PurchaseItem(
    val purchaseItemId: Int,
    val purchaseId: Int,
    val productId: Int,
    val quantity: Int,
    val purchasePrice: Double
)