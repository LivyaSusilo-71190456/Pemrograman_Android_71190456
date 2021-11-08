package id.ac.ukdw.pertemuan9_71190456_sp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    var sp: SharedPreferences? = null
    var spedit: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sp = getSharedPreferences(
            "spname", Context.MODE_PRIVATE
        )

        spedit = sp?.edit()

        if(sp?.getBoolean("isLogin", false) == true){
            setContentView(R.layout.activity_home)

            val spnlang = findViewById<Spinner>(R.id.spnlang)
            val adapterlang = ArrayAdapter.createFromResource(
                this, R.array.lang_list,
                R.layout.support_simple_spinner_dropdown_item)
            spnlang.adapter = adapterlang
            spnlang.setSelection(sp!!.getInt("bahasa", 1))
            spnlang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, id: Long) {
                    spedit?.putInt("bahasa", position)
                    spedit?.commit()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

            val spnsize = findViewById<Spinner>(R.id.spnsize)
            val adaptersize = ArrayAdapter.createFromResource(
                this, R.array.size_list,
                R.layout.support_simple_spinner_dropdown_item
            )
            spnsize.adapter = adaptersize
            spnsize.setSelection(sp!!.getInt("size", 1))
            spnsize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, id: Long) {
                    spedit?.putInt("size", position)
                    spedit?.commit()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }


        }else{
            setContentView(R.layout.activity_main)
            val etuser = findViewById<EditText>(R.id.etuser)
            val etpassword = findViewById<EditText>(R.id.etpassword)
            val btnlogin = findViewById<Button>(R.id.btnlogin)
            btnlogin.setOnClickListener{
                if(etuser.text.toString() == "admin" && etpassword.text.toString() == "1234"){
                    spedit?.putBoolean("islogin", true)
                    spedit?.commit()
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                }
            }
        }

    }
}