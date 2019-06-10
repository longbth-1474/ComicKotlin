package com.hoanglong.comickotlin.utils

import android.content.Context
import android.widget.Toast

class Utils {

    companion object {
        fun toast(context: Context?, message: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, length).show()
        }
    }

}