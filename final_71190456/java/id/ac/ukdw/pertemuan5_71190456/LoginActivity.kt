package id.ac.ukdw.pertemuan5_71190456

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etusername = findViewById<EditText>(R.id.username)
        val etpassword = findViewById<EditText>(R.id.password)
        val btnlogin = findViewById<Button>(R.id.login)

        btnlogin.setOnClickListener {
            if(etpassword.text.equals("qwerty")){
                toast("login berhasil")}
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtras("username",etusername.text.toString()     )
            startActivity(intent)
            else{
                toast("login gagal")}
        }
    }


    fun toast(message: String){
        Toast.makeText(this, Toast.LENGTH_SHORT).show()
    }
}

private fun Parcelable.putExtras(s: String, toString: String) {

}
