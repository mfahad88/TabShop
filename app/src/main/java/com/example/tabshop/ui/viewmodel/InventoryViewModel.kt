package com.example.tabshop.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tabshop.data.model.*
import com.example.tabshop.data.repository.InventoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InventoryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = InventoryRepository(application)

    // -------------------------
    // Categories
    // -------------------------
    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    fun loadCategories() {
        viewModelScope.launch {
            _categories.value = withContext(Dispatchers.IO) { repository.getCategories() }
        }
    }

    fun addCategory(name: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.addCategory(name)
        loadCategories()
    }

    fun updateCategory(id: Int, name: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateCategory(id, name)
        loadCategories()
    }

    fun deleteCategory(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteCategory(id)
        loadCategories()
    }

    // -------------------------
    // Products
    // -------------------------
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun loadProducts() {
        viewModelScope.launch {
            _products.value = withContext(Dispatchers.IO) { repository.getProducts() }
        }
    }

    fun addProduct(
        name: String, categoryId: Int, brand: String?, unit: String?, description: String?,
        purchasePrice: Double, sellingPrice: Double, stockQuantity: Int, barcode: String?, imagePath: String?
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.addProduct(name, categoryId, brand, unit, description, purchasePrice, sellingPrice, stockQuantity, barcode, imagePath)
        loadProducts()
    }

    fun updateProduct(
        productId: Int, name: String, categoryId: Int, brand: String?, unit: String?, description: String?,
        purchasePrice: Double, sellingPrice: Double, stockQuantity: Int, barcode: String?, imagePath: String?
    ) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateProduct(productId, name, categoryId, brand, unit, description, purchasePrice, sellingPrice, stockQuantity, barcode, imagePath)
        loadProducts()
    }

    fun deleteProduct(productId: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteProduct(productId)
        loadProducts()
    }

    // -------------------------
    // Suppliers
    // -------------------------
    private val _suppliers = MutableLiveData<List<Supplier>>()
    val suppliers: LiveData<List<Supplier>> = _suppliers

    fun loadSuppliers() {
        viewModelScope.launch {
            _suppliers.value = withContext(Dispatchers.IO) { repository.getSuppliers() }
        }
    }

    fun addSupplier(name: String, contact: String?, address: String?) = viewModelScope.launch(Dispatchers.IO) {
        repository.addSupplier(name, contact, address)
        loadSuppliers()
    }

    fun updateSupplier(id: Int, name: String, contact: String?, address: String?) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateSupplier(id, name, contact, address)
        loadSuppliers()
    }

    fun deleteSupplier(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteSupplier(id)
        loadSuppliers()
    }

    // -------------------------
    // Customers
    // -------------------------
    private val _customers = MutableLiveData<List<Customer>>()
    val customers: LiveData<List<Customer>> = _customers

    fun loadCustomers() {
        viewModelScope.launch {
            _customers.value = withContext(Dispatchers.IO) { repository.getCustomers() }
        }
    }

    fun addCustomer(name: String, contact: String?, address: String?) = viewModelScope.launch(Dispatchers.IO) {
        repository.addCustomer(name, contact, address)
        loadCustomers()
    }

    fun updateCustomer(id: Int, name: String, contact: String?, address: String?) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateCustomer(id, name, contact, address)
        loadCustomers()
    }

    fun deleteCustomer(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteCustomer(id)
        loadCustomers()
    }

    // -------------------------
    // Purchases
    // -------------------------
    private val _purchases = MutableLiveData<List<Purchase>>()
    val purchases: LiveData<List<Purchase>> = _purchases

    fun loadPurchases() {
        viewModelScope.launch {
            _purchases.value = withContext(Dispatchers.IO) { repository.getPurchases() }
        }
    }

    fun addPurchase(supplierId: Int?, invoiceNo: String?, purchaseDate: String, totalAmount: Double?) = viewModelScope.launch(Dispatchers.IO) {
        repository.addPurchase(supplierId, invoiceNo, purchaseDate, totalAmount)
        loadPurchases()
    }

    fun addPurchaseItem(purchaseId: Int, productId: Int, quantity: Int, purchasePrice: Double) = viewModelScope.launch(Dispatchers.IO) {
        repository.addPurchaseItem(purchaseId, productId, quantity, purchasePrice)
    }

    // -------------------------
    // Sales
    // -------------------------
    private val _sales = MutableLiveData<List<Sale>>()
    val sales: LiveData<List<Sale>> = _sales

    fun loadSales() {
        viewModelScope.launch {
            _sales.value = withContext(Dispatchers.IO) { repository.getSales() }
        }
    }

    fun addSale(customerId: Int?, saleDate: String, totalAmount: Double?, discount: Double, paymentMethod: String?) = viewModelScope.launch(Dispatchers.IO) {
        repository.addSale(customerId, saleDate, totalAmount, discount, paymentMethod)
        loadSales()
    }

    fun addSaleItem(saleId: Int, productId: Int, quantity: Int, sellingPrice: Double) = viewModelScope.launch(Dispatchers.IO) {
        repository.addSaleItem(saleId, productId, quantity, sellingPrice)
    }

    // -------------------------
    // Users
    // -------------------------
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = withContext(Dispatchers.IO) { repository.getUsers() }
        }
    }

    fun addUser(username: String, password: String, role: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(username, password, role)
        loadUsers()
    }
}
