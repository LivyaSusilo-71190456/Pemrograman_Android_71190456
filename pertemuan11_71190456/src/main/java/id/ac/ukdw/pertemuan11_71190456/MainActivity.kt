package id.ac.ukdw.pertemuan11_71190456

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    val firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etnama = findViewById<EditText>(R.id.etnama)
        val etnim = findViewById<EditText>(R.id.etnim)
        val etipk = findViewById<EditText>(R.id.etipk)

        val btnsimpan = findViewById<Button>(R.id.btnsimpan)
        val btncari = findViewById<Button>(R.id.btncari)

        val tvhasil = findViewById<TextView>(R.id.tvhasil)

        btnsimpan.setOnClickListener {
            val mahasiswa = Mahasiswa (etnama.text.toString(), etnim.text.toString(), etipk.text.toFloat())
            etnama.setText("")
            etnim.setText("")
            etipk.setText("")
            firestore?.collection("mahasiswa")?.add(mahasiswa)
        }
        btncari.setOnClickListener {
            firestore?.collection("mahasiswa")?.get()!!
                .addOnSuccessListener{doc ->
                    var hasil = ""
                    for(d in doc){
                        hasil += "\n${d["nama"]}"
                    }
                    tvhasil.setText(hasil.toSortedSet())
                }
        }
    }
}

private fun TextView.setText(sortedSet: Collection<Char>) {
    TODO("Not yet implemented")
}

private fun Editable.toFloat() {

}
