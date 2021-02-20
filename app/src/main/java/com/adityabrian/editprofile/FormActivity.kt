package com.adityabrian.editprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    lateinit var profilPreference: ProfilPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        profilPreference = ProfilPreference(this)

        if(profilPreference.preference.contains(ProfilPreference.NAME)){
            val profil = profilPreference.getProfile()
            ed_Nama.setText(profil.name)
            profil.age?.let { ed_Umur.setText(it.toString()) }
            ed_Gender.setText(profil.gender)
            ed_Alamat.setText(profil.addres)
            ed_Negara.setText(profil.national)
        }
        btn_Save.setOnClickListener{
                /** kita tampung inputnya ke variabel ke toString() dan trim()*/
            val name = ed_Nama.text.toString().trim()
            val age = ed_Umur.text.toString().trim()
            val gender = ed_Gender.text.toString().trim()
            val address = ed_Alamat.text.toString().trim()
            val national = ed_Negara.text.toString().trim()

                /** bentuk model lagi*/
            val profil = Profile(
                    name,
                    age.toInt(),
                    gender,
                    address,
                    national
            )
            saveToPreference(profil)
        }
    }

    private fun saveToPreference(profil: Profile) {
        profilPreference.setProfile(profil)
        Toast.makeText(this,"Data Berhasil Disimpan !",Toast.LENGTH_LONG).show()
        Intent(this,MainActivity::class.java).also {
                /** kita membuat fungsi agar bisa menghindari stack berlebih saat sudah dilakukan
                 *  pengeditan*/
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}