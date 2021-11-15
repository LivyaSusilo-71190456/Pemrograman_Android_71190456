package id.ac.ukdw.pertemuan10_71190456

import android.content.Context
import android.content.SyncContext
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.contentcapture.ContentCaptureContext

class DatabaseHelper(val context: Context) : SQLiteOpenHelper(context: Context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DatabaseContract.Penduduk.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DatabaseContract.Penduduk.SQL_DELETE_TABLE)
        onCreate(db)
    }
    companion object info{
        const val DATABASE_NAME = "myDB"
        const val DATABASE_VERSION = 1
    }
}