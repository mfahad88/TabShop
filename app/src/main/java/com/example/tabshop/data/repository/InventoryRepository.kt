package com.example.tabshop.data.repository

import android.content.Context
import com.example.tabshop.data.db.DatabaseQueries
import com.example.tabshop.data.model.*

class InventoryRepository(context: Context) {

    private val dbQueries = DatabaseQueries(context)

    // -------------------------
    // Categories
    // -------------------------
    fun getCategories(): List<Category> {
        val cursor = dbQueries.getAllCategories()
        val list = mutableListOf<Category>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        Category(
                            categoryId = it.getInt(it.getColumnIndexOrThrow("category_id")),
                            name = it.getString(it.getColumnIndexOrThrow("name"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addCategory(name: String): Long = dbQueries.insertCategory(name)
    fun updateCategory(id: Int, name: String): Int = dbQueries.updateCategory(id, name)
    fun deleteCategory(id: Int): Int = dbQueries.deleteCategory(id)

    // -------------------------
    // Products
    // -------------------------
    fun getProducts(): List<Product> {
        val cursor = dbQueries.getAllProducts()
        val list = mutableListOf<Product>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        Product(
                            productId = it.getInt(it.getColumnIndexOrThrow("product_id")),
                            name = it.getString(it.getColumnIndexOrThrow("name")),
                            categoryId = it.getInt(it.getColumnIndexOrThrow("category_id")),
                            brand = it.getString(it.getColumnIndexOrThrow("brand")),
                            unit = it.getString(it.getColumnIndexOrThrow("unit")),
                            description = it.getString(it.getColumnIndexOrThrow("description")),
                            purchasePrice = it.getDouble(it.getColumnIndexOrThrow("purchase_price")),
                            sellingPrice = it.getDouble(it.getColumnIndexOrThrow("selling_price")),
                            stockQuantity = it.getInt(it.getColumnIndexOrThrow("stock_quantity")),
                            barcode = it.getString(it.getColumnIndexOrThrow("barcode")),
                            imagePath = it.getString(it.getColumnIndexOrThrow("image_path"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addProduct(
        name: String, categoryId: Int, brand: String?, unit: String?, description: String?,
        purchasePrice: Double, sellingPrice: Double, stockQuantity: Int, barcode: String?, imagePath: String?
    ): Long = dbQueries.insertProduct(
        name, categoryId, brand, unit, description,
        purchasePrice, sellingPrice, stockQuantity, barcode, imagePath
    )

    fun updateProduct(
        productId: Int, name: String, categoryId: Int, brand: String?, unit: String?, description: String?,
        purchasePrice: Double, sellingPrice: Double, stockQuantity: Int, barcode: String?, imagePath: String?
    ): Int = dbQueries.updateProduct(
        productId, name, categoryId, brand, unit, description,
        purchasePrice, sellingPrice, stockQuantity, barcode, imagePath
    )

    fun deleteProduct(productId: Int): Int = dbQueries.deleteProduct(productId)

    // -------------------------
    // Suppliers
    // -------------------------
    fun getSuppliers(): List<Supplier> {
        val cursor = dbQueries.getAllSuppliers()
        val list = mutableListOf<Supplier>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        Supplier(
                            supplierId = it.getInt(it.getColumnIndexOrThrow("supplier_id")),
                            name = it.getString(it.getColumnIndexOrThrow("name")),
                            contact = it.getString(it.getColumnIndexOrThrow("contact")),
                            address = it.getString(it.getColumnIndexOrThrow("address"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addSupplier(name: String, contact: String?, address: String?): Long =
        dbQueries.insertSupplier(name, contact, address)

    fun updateSupplier(id: Int, name: String, contact: String?, address: String?): Int =
        dbQueries.updateSupplier(id, name, contact, address)

    fun deleteSupplier(id: Int): Int = dbQueries.deleteSupplier(id)

    // -------------------------
    // Customers
    // -------------------------
    fun getCustomers(): List<Customer> {
        val cursor = dbQueries.getAllCustomers()
        val list = mutableListOf<Customer>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        Customer(
                            customerId = it.getInt(it.getColumnIndexOrThrow("customer_id")),
                            name = it.getString(it.getColumnIndexOrThrow("name")),
                            contact = it.getString(it.getColumnIndexOrThrow("contact")),
                            address = it.getString(it.getColumnIndexOrThrow("address"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addCustomer(name: String, contact: String?, address: String?): Long =
        dbQueries.insertCustomer(name, contact, address)

    fun updateCustomer(id: Int, name: String, contact: String?, address: String?): Int =
        dbQueries.updateCustomer(id, name, contact, address)

    fun deleteCustomer(id: Int): Int = dbQueries.deleteCustomer(id)

    // -------------------------
    // Purchases
    // -------------------------
    fun getPurchases(): List<Purchase> {
        val cursor = dbQueries.getAllPurchases()
        val list = mutableListOf<Purchase>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        Purchase(
                            purchaseId = it.getInt(it.getColumnIndexOrThrow("purchase_id")),
                            supplierId = it.getInt(it.getColumnIndexOrThrow("supplier_id")),
                            invoiceNo = it.getString(it.getColumnIndexOrThrow("invoice_no")),
                            purchaseDate = it.getString(it.getColumnIndexOrThrow("purchase_date")),
                            totalAmount = it.getDouble(it.getColumnIndexOrThrow("total_amount"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addPurchase(supplierId: Int?, invoiceNo: String?, purchaseDate: String, totalAmount: Double?): Long =
        dbQueries.insertPurchase(supplierId, invoiceNo, purchaseDate, totalAmount)

    fun addPurchaseItem(purchaseId: Int, productId: Int, quantity: Int, purchasePrice: Double): Long =
        dbQueries.insertPurchaseItem(purchaseId, productId, quantity, purchasePrice)

    // -------------------------
    // Sales
    // -------------------------
    fun getSales(): List<Sale> {
        val cursor = dbQueries.getAllSales()
        val list = mutableListOf<Sale>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        Sale(
                            saleId = it.getInt(it.getColumnIndexOrThrow("sale_id")),
                            customerId = it.getInt(it.getColumnIndexOrThrow("customer_id")),
                            saleDate = it.getString(it.getColumnIndexOrThrow("sale_date")),
                            totalAmount = it.getDouble(it.getColumnIndexOrThrow("total_amount")),
                            discount = it.getDouble(it.getColumnIndexOrThrow("discount")),
                            paymentMethod = it.getString(it.getColumnIndexOrThrow("payment_method"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addSale(customerId: Int?, saleDate: String, totalAmount: Double?, discount: Double, paymentMethod: String?): Long =
        dbQueries.insertSale(customerId, saleDate, totalAmount, discount, paymentMethod)

    fun addSaleItem(saleId: Int, productId: Int, quantity: Int, sellingPrice: Double): Long =
        dbQueries.insertSaleItem(saleId, productId, quantity, sellingPrice)

    // -------------------------
    // Users
    // -------------------------
    fun getUsers(): List<User> {
        val cursor = dbQueries.getAllUsers()
        val list = mutableListOf<User>()
        cursor.use {
            if (it.moveToFirst()) {
                do {
                    list.add(
                        User(
                            userId = it.getInt(it.getColumnIndexOrThrow("user_id")),
                            username = it.getString(it.getColumnIndexOrThrow("username")),
                            password = it.getString(it.getColumnIndexOrThrow("password")),
                            role = it.getString(it.getColumnIndexOrThrow("role"))
                        )
                    )
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun addUser(username: String, password: String, role: String): Long =
        dbQueries.insertUser(username, password, role)
}
