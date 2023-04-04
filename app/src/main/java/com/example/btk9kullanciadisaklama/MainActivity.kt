package com.example.btk9kullanciadisaklama

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences //Tanımladık Değeri sonradan giriceğiz demek
    var alinanKullaniciAdi : String ? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ShaeredPreferences

        sharedPreferences = this.getSharedPreferences("btk9kullanciadisaklama",
                MODE_PRIVATE)

        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
        if(alinanKullaniciAdi != null){
            textView.text="Kaydedilen Kullanıcı Adı: ${alinanKullaniciAdi}" //Tam Kayıt her açılışta gösterir
        }
    }

    fun kaydet(view: View){
        val kullaniciAdi= editText.text.toString()
        if(kullaniciAdi == ""){
            Toast.makeText(this,"Lüften bir değer giriniz",Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString("kullanici",kullaniciAdi).apply()//Kaydettik
            textView.text = "Kaydedilen Kullanıcı Adı: ${kullaniciAdi}"
        }
    }

    fun sil(view: View){

        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
        if(alinanKullaniciAdi != null){
            textView.text="Kaydedilen Kullanici Adi: "
            sharedPreferences.edit().remove("kullanici").apply() //Sildik
        }

    }
}