package com.example.tabshop.data.model

data class Purchase(
    val purchaseId: Int,
    val supplierId: Int?,
    val invoiceNo: String?,
    val purchaseDate: String,
    val totalAmount: Double?
)