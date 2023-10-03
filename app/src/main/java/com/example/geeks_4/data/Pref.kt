package com.example.geeks_4.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
class Pref(private val context:Context) {
    private val pref = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE)

    fun isUserShow(): Boolean{
        return pref.getBoolean(BOARD_KEY, false)
    }

    fun userShowed(){
        pref.edit().putBoolean(BOARD_KEY, true).apply()
    }

    fun  saveText(text:String){
        pref.edit().putString(TEXT_KEY,text).apply()
    }

    fun  saveImage(image:String){
        pref.edit().putString(IMAGE_KEY,image).apply()
    }

    fun getText() = pref.getString(TEXT_KEY, "")

    fun getImage() = pref.getString(IMAGE_KEY, "")


    companion object{
        const val TEXT_KEY = "text.key"

        const val PREF_KEY = "pref.key"
        const val BOARD_KEY = "board.key"
        const val IMAGE_KEY = "image.key"
    }
}