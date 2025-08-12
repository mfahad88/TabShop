package com.example.tabshop.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.tabshop.data.model.*

class DatabaseQueries(private val context: Context) {

    private val dbHelper = DatabaseHelper(context)

    // -------------------------
    // Products
    // -------------------------
    fun getAllProducts(): List<Product> {
        val db = dbHelper.openDatabase()
        val cursor = db.rawQuery("SELECT * FROM products", null)
        val products = mutableListOf<Product>()
        cursor.use {
            while (it.moveToNext()) {
                products.add(
                    Product(
                        id = it.getInt(it.getColumnIndexOrThrow("id")),
                        sku = it.getString(it.getColumnIndexOrThrow("sku")),
                        name = it.getString(it.getColumnIndexOrThrow("name")),
                        sellingPrice = it.getDouble(it.getColumnIndexOrThrow("selling_price")),
                        stockQuantity = it.getDouble(it.getColumnIndexOrThrow("stock_quantity")),
                        reorderLevel = it.getDouble(it.getColumnIndexOrThrow("reorder_level")),
                        expiryDate = it.getString(it.getColumnIndexOrThrow("expiry_date")),
                        isActive = it.getInt(it.getColumnIndexOrThrow("isActive")) == 1,
                        isDeleted = it.getInt(it.getColumnIndexOrThrow("isDeleted")) == 1
                    )
                )
            }
        }
        return products
    }

    fun insertProduct(product: Product): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("sku", product.sku)
            put("name", product.name)
            put("selling_price", product.sellingPrice)
            put("stock_quantity", product.stockQuantity)
            put("reorder_level", product.reorderLevel)
            put("expiry_date", product.expiryDate)
            put("isActive", if (product.isActive) 1 else 0)
            put("isDeleted", if (product.isDeleted) 1 else 0)
        }
        return db.insert("products", null, values)
    }

    fun updateProduct(product: Product): Int {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("sku", product.sku)
            put("name", product.name)
            put("selling_price", product.sellingPrice)
            put("stock_quantity", product.stockQuantity)
            put("reorder_level", product.reorderLevel)
            put("expiry_date", product.expiryDate)
            put("isActive", if (product.isActive) 1 else 0)
            put("isDeleted", if (product.isDeleted) 1 else 0)
        }
        return db.update("products", values, "id=?", arrayOf(product.id.toString()))
    }

    fun deleteProduct(id: Int): Int {
        val db = dbHelper.openDatabase()
        return db.delete("products", "id=?", arrayOf(id.toString()))
    }

    // -------------------------
    // Customers
    // -------------------------
    fun getAllCustomers(): List<Customer> {
        val db = dbHelper.openDatabase()
        val cursor = db.rawQuery("SELECT * FROM customers", null)
        val customers = mutableListOf<Customer>()
        cursor.use {
            while (it.moveToNext()) {
                customers.add(
                    Customer(
                        id = it.getInt(it.getColumnIndexOrThrow("id")),
                        name = it.getString(it.getColumnIndexOrThrow("name")),
                        phone = it.getString(it.getColumnIndexOrThrow("phone")),
                        isActive = it.getInt(it.getColumnIndexOrThrow("isActive")) == 1,
                        isDeleted = it.getInt(it.getColumnIndexOrThrow("isDeleted")) == 1
                    )
                )
            }
        }
        return customers
    }

    fun insertCustomer(customer: Customer): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", customer.name)
            put("phone", customer.phone)
            put("isActive", if (customer.isActive) 1 else 0)
            put("isDeleted", if (customer.isDeleted) 1 else 0)
        }
        return db.insert("customers", null, values)
    }

    fun updateCustomer(customer: Customer): Int {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", customer.name)
            put("phone", customer.phone)
            put("isActive", if (customer.isActive) 1 else 0)
            put("isDeleted", if (customer.isDeleted) 1 else 0)
        }
        return db.update("customers", values, "id=?", arrayOf(customer.id.toString()))
    }

    fun deleteCustomer(id: Int): Int {
        val db = dbHelper.openDatabase()
        return db.delete("customers", "id=?", arrayOf(id.toString()))
    }

    // -------------------------
    // Users
    // -------------------------
    fun getAllUsers(): List<User> {
        val db = dbHelper.openDatabase()
        val cursor = db.rawQuery("SELECT * FROM users", null)
        val users = mutableListOf<User>()
        cursor.use {
            while (it.moveToNext()) {
                users.add(
                    User(
                        id = it.getInt(it.getColumnIndexOrThrow("id")),
                        name = it.getString(it.getColumnIndexOrThrow("name")),
                        username = it.getString(it.getColumnIndexOrThrow("username")),
                        password = it.getString(it.getColumnIndexOrThrow("password")),
                        role = it.getString(it.getColumnIndexOrThrow("role")),
                        isActive = it.getInt(it.getColumnIndexOrThrow("isActive")) == 1,
                        isDeleted = it.getInt(it.getColumnIndexOrThrow("isDeleted")) == 1
                    )
                )
            }
        }
        return users
    }

    fun insertUser(user: User): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", user.name)
            put("username", user.username)
            put("password", user.password)
            put("role", user.role)
            put("isActive", if (user.isActive) 1 else 0)
            put("isDeleted", if (user.isDeleted) 1 else 0)
        }
        return db.insert("users", null, values)
    }
}
