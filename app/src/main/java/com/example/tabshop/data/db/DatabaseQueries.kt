package com.example.tabshop.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DatabaseQueries(private val context: Context) {

    private val dbHelper = DatabaseHelper(context)

    // -------------------------
    // Categories
    // -------------------------
    fun getAllCategories(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM categories", null)
    }

    fun insertCategory(name: String): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
        }
        return db.insert("categories", null, values)
    }

    fun updateCategory(id: Int, name: String): Int {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
        }
        return db.update("categories", values, "category_id=?", arrayOf(id.toString()))
    }

    fun deleteCategory(id: Int): Int {
        val db = dbHelper.openDatabase()
        return db.delete("categories", "category_id=?", arrayOf(id.toString()))
    }

    // -------------------------
    // Products
    // -------------------------
    fun getAllProducts(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM products", null)
    }

    fun insertProduct(
        name: String, categoryId: Int, brand: String?, unit: String?,
        description: String?, purchasePrice: Double, sellingPrice: Double,
        stockQuantity: Int, barcode: String?, imagePath: String?
    ): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
            put("category_id", categoryId)
            put("brand", brand)
            put("unit", unit)
            put("description", description)
            put("purchase_price", purchasePrice)
            put("selling_price", sellingPrice)
            put("stock_quantity", stockQuantity)
            put("barcode", barcode)
            put("image_path", imagePath)
        }
        return db.insert("products", null, values)
    }

    fun updateProduct(
        productId: Int, name: String, categoryId: Int, brand: String?, unit: String?,
        description: String?, purchasePrice: Double, sellingPrice: Double,
        stockQuantity: Int, barcode: String?, imagePath: String?
    ): Int {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
            put("category_id", categoryId)
            put("brand", brand)
            put("unit", unit)
            put("description", description)
            put("purchase_price", purchasePrice)
            put("selling_price", sellingPrice)
            put("stock_quantity", stockQuantity)
            put("barcode", barcode)
            put("image_path", imagePath)
        }
        return db.update("products", values, "product_id=?", arrayOf(productId.toString()))
    }

    fun deleteProduct(productId: Int): Int {
        val db = dbHelper.openDatabase()
        return db.delete("products", "product_id=?", arrayOf(productId.toString()))
    }

    // -------------------------
    // Suppliers
    // -------------------------
    fun getAllSuppliers(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM suppliers", null)
    }

    fun insertSupplier(name: String, contact: String?, address: String?): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
            put("contact", contact)
            put("address", address)
        }
        return db.insert("suppliers", null, values)
    }

    fun updateSupplier(id: Int, name: String, contact: String?, address: String?): Int {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
            put("contact", contact)
            put("address", address)
        }
        return db.update("suppliers", values, "supplier_id=?", arrayOf(id.toString()))
    }

    fun deleteSupplier(id: Int): Int {
        val db = dbHelper.openDatabase()
        return db.delete("suppliers", "supplier_id=?", arrayOf(id.toString()))
    }

    // -------------------------
    // Customers
    // -------------------------
    fun getAllCustomers(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM customers", null)
    }

    fun insertCustomer(name: String, contact: String?, address: String?): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
            put("contact", contact)
            put("address", address)
        }
        return db.insert("customers", null, values)
    }

    fun updateCustomer(id: Int, name: String, contact: String?, address: String?): Int {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("name", name)
            put("contact", contact)
            put("address", address)
        }
        return db.update("customers", values, "customer_id=?", arrayOf(id.toString()))
    }

    fun deleteCustomer(id: Int): Int {
        val db = dbHelper.openDatabase()
        return db.delete("customers", "customer_id=?", arrayOf(id.toString()))
    }

    // -------------------------
    // Purchases & Purchase Items
    // -------------------------
    fun getAllPurchases(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM purchases", null)
    }

    fun insertPurchase(supplierId: Int?, invoiceNo: String?, purchaseDate: String, totalAmount: Double?): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("supplier_id", supplierId)
            put("invoice_no", invoiceNo)
            put("purchase_date", purchaseDate)
            put("total_amount", totalAmount)
        }
        return db.insert("purchases", null, values)
    }

    fun insertPurchaseItem(purchaseId: Int, productId: Int, quantity: Int, purchasePrice: Double): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("purchase_id", purchaseId)
            put("product_id", productId)
            put("quantity", quantity)
            put("purchase_price", purchasePrice)
        }
        return db.insert("purchase_items", null, values)
    }

    // -------------------------
    // Sales & Sale Items
    // -------------------------
    fun getAllSales(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM sales", null)
    }

    fun insertSale(customerId: Int?, saleDate: String, totalAmount: Double?, discount: Double, paymentMethod: String?): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("customer_id", customerId)
            put("sale_date", saleDate)
            put("total_amount", totalAmount)
            put("discount", discount)
            put("payment_method", paymentMethod)
        }
        return db.insert("sales", null, values)
    }

    fun insertSaleItem(saleId: Int, productId: Int, quantity: Int, sellingPrice: Double): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("sale_id", saleId)
            put("product_id", productId)
            put("quantity", quantity)
            put("selling_price", sellingPrice)
        }
        return db.insert("sale_items", null, values)
    }

    // -------------------------
    // Users
    // -------------------------
    fun getAllUsers(): Cursor {
        val db = dbHelper.openDatabase()
        return db.rawQuery("SELECT * FROM users", null)
    }

    fun insertUser(username: String, password: String, role: String): Long {
        val db = dbHelper.openDatabase()
        val values = ContentValues().apply {
            put("username", username)
            put("password", password)
            put("role", role)
        }
        return db.insert("users", null, values)
    }
}
