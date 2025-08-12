package com.example.tabshop.data.model

data class User(
    val id: Int = 0,
    val name: String,
    val username: String,
    val password: String,
    val role: String, // Admin, Cashier, Manager, etc.
    val isActive: Boolean = true,
    val isDeleted: Boolean = false
)