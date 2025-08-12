package com.example.tabshop.data.model

data class Supplier(
    val id: Int = 0,
    val name: String,
    val phone: String? = null,
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)