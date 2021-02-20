package com.adityabrian.editprofile

import android.content.Context

class ProfilPreference(context: Context) {
    companion object{
        const val SP_NAME = "profile pref"
        const val NAME = "name"
        const val AGE = "age"
        const val GENDER = "gender"
        const val ADDRESS = "address"
        const val NATIONAL = "Nasional"
    }
        /** kita buat preferencenya biar bisa dipangggil*/
    val preference = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE)

        /** MEMBUAT FUNGSI SETTER DAN GETTER*/
    fun setProfile(profile: Profile){
        val prefEditor = preference.edit()

            prefEditor.putString(NAME,profile.name)
            profile.age?.let { prefEditor.putInt(AGE, it) }
            prefEditor.putString(GENDER,profile.gender)
            prefEditor.putString(ADDRESS,profile.addres)
            prefEditor.putString(NATIONAL,profile.national)

            prefEditor.apply()
    }

    fun getProfile():Profile {
        val profile = Profile()

        profile.name = preference.getString(NAME,"")
        profile.age = preference.getInt(AGE,0)
        profile.gender = preference.getString(GENDER,"Tidak Di Isi !")
        profile.addres = preference.getString(ADDRESS,"Belum Di Isi !")
        profile.national = preference.getString(NATIONAL, "Tidak Diketahui")
        return profile
    }
}