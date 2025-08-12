package com.example.tabshop.data.model

data class PurchaseItem(
    val id: Int = 0,
    val purchaseId: Int,
    val productId: Int,
    val quantity: Double,
    val unitPrice: Double,
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)