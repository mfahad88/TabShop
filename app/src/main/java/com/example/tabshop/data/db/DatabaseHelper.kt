package com.example.tabshop.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream

class DatabaseHelper(private val mContext: Context) :
    SQLiteOpenHelper(mContext, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "inv_pos.db"
        private const val DB_VERSION = 1
    }

    private val dbPath: String = mContext.getDatabasePath(DB_NAME).path

    override fun onCreate(db: SQLiteDatabase?) {
        // No need, we’re using a preloaded DB
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // If you change DB version, handle upgrade here
    }

    fun openDatabase(): SQLiteDatabase {
        val dbFile = File(dbPath)
        if (!dbFile.exists()) {
            copyDatabase()
        }
        return SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE)
    }

    private fun copyDatabase() {
        val inputStream = mContext.assets.open("databases/$DB_NAME")
        val outFile = File(dbPath)
        outFile.parentFile?.mkdirs()
        val outputStream = FileOutputStream(outFile)

        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }

        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }
}
