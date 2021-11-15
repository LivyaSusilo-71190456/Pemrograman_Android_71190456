package id.ac.ukdw.pertemuan10_71190456

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this).writableDatabase
        val etnama = findViewById<EditText>(R.id.etnama)
        val etusia = findViewById<EditText>(R.id.etusia)
        val btnsimpan = findViewById<Button>(R.id.btnsimpan)
        val btnhapus = findViewById<Button>(R.id.btnhapus)

        btnsimpan.setOnClickListener {
            insertData(penduduk(etnama.text.toString(), etusia.text.toString().toInt()))
            etnama.setText("")
            etusia.setText("")
        }

        btnhapus.setOnClickListener {
            deleteData(penduduk(etnama.text.toString(), etusia.text.toString().toInt()))
            etnama.setText("")
            etusia.setText("")
        }

        getData()
    }

    fun insertData(penduduk: penduduk){
        val velues = ContentValues().apply {
            put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, penduduk.nama)
            put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, penduduk.usia)
        }
        db.insert(DatabaseContract.Penduduk.TABLE_NAME, null, values)
    }

    fun deleteData(penduduk: penduduk){
        val selection = "$(DatabaseContract.Penduduk.COLUMN_NAME_NAMA) LIKE ?"+
                " OR $(DatabaseContract.Penduduk.COLUMN_NAME_NAMA) = ?"
        val selectionArgs = arrayOf(penduduk.nama, penduduk.usia.toString())

        db.delete(DatabaseContract.Penduduk.TABLE_NAME, selection, selectionArgs)
    }

    fun getData(penduduk: penduduk){
        val columns = arrayOf(
            DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
            DatabaseContract.Penduduk.COLUMN_NAME_USIA
        )

        val cursor = db.query(
            DatabaseContract.Penduduk.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        var result = ""
        with(cursor){
            while(moveToNext()){
                val penduduk = penduduk (getString(0), getInt(1))
                result += "${penduduk.nama} - ${penduduk.usia}/n"
            }
        }
    }
    val tvtampil = findViewById<TextView>(R.id.tvtampil)
    tvhasil.text = result
}