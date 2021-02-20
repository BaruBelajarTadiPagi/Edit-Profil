package com.adityabrian.editprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var profilPreference: ProfilPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profilPreference = ProfilPreference(this)

        if(profilPreference.preference.contains(ProfilPreference.NAME)){
            val profile = profilPreference.getProfile()
            tv_Name.text = profile.name
            tv_Age.text = profile.age.toString()
            tv_Gender.text = profile.gender
            tv_Address.text = profile.addres
            tv_Negara.text = profile.national
        }

        btn_Edit.setOnClickListener{
            Intent(this,FormActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}