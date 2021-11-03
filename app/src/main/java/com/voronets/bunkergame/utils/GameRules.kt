package com.voronets.bunkergame.utils


import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.voronets.bunkergame.R

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
