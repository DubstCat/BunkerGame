package com.voronets.bunkergame.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import com.voronets.bunkergame.DataClasses.MainInfo
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.fragment_catast.*
import kotlin.random.Random

/**
 * A [Fragment] for displaying game situation info.
 */
class CatastFragment : Fragment(R.layout.fragment_catast) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCatastText()
        bindListeners()
    }

    private fun setCatastText(){
        for ((key, value) in MainInfo.savedCatastText.entries) {
            text_view_catast_title.text = key
        }
        text_view_catast.text = MainInfo.savedCatastText[text_view_catast_title.text.toString()]

    }

    @SuppressLint("SetTextI18n")
    private fun bindListeners(){
        btn_generate_catast.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle("Перегенерация катастрофы")
                .setMessage("Вы уверены, что хотите перегенерировать катастрофу?")
                .setPositiveButton("Да") { _, _ ->
                    text_view_catast_title.text = MainInfo.catast.keys.shuffled()[0]
                    text_view_catast.text = MainInfo.catast.get(text_view_catast_title.text.toString()) +"" +
                            "\nВремя нахождения в бункере - ${Random.nextInt(1,50)} лет" +
                            "\nЗапасов воды и еды на ${Random.nextInt(1,50)} лет"+
                            "\nХарактеристика бункера - ${resources.getStringArray(R.array.bonus_items).toList().shuffled()[0]}"
                    text_view_catast.movementMethod = LinkMovementMethod.getInstance()
                    MainInfo.savedCatastText = hashMapOf(text_view_catast_title.text.toString() to text_view_catast.text.toString()) }
                .setNeutralButton("Нет",null) .create().show()
        }
        btn_generate_catast.setOnLongClickListener{
            AlertDialog.Builder(context)
                .setTitle("Правила игры")
                .setMessage(getString(R.string.rules_text))
                .setPositiveButton("Окей", null)
                .create()
                .show()
            true
        }
    }

}
