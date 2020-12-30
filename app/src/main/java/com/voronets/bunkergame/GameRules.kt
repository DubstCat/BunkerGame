package com.voronets.bunkergame


import android.content.Context
import androidx.appcompat.app.AlertDialog

object GameRules {
    fun showRules(context: Context){
            val dialog = AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.rules))
                .setMessage(context.getString(R.string.rules_text))
                .setPositiveButton(context.getString(R.string.rules_accept), null)
                .create()
                .show()
        }
    }
