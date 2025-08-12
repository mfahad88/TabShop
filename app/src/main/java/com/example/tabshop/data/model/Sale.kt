package com.example.tabshop.data.model

data class Sale(
    val saleId: Int,
    val customerId: Int?,
    val saleDate: String,
    val totalAmount: Double?,
    val discount: Double = 0.0,
    val paymentMethod: String?
)