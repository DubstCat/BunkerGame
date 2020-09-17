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

        text_view_catast.text = MainInfo.savedCatastText

        button_catast.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle("Перегенерация катастрофы")
                .setMessage("Вы уверены, что хотите перегенерировать катастрофу?")
                .setPositiveButton("Да") { _, _ ->
                    text_view_catast.text = MainInfo.catast.shuffled()[0] +"" +
                            "\nВремя нахождения в бункере - ${Random.nextInt(1,50)} лет" +
                            "\nЗапасов воды и еды на ${Random.nextInt(1,50)} лет"+
                            "\nХарактеристика бункера - ${MainInfo.bonus_items.shuffled()[0]}"+
                            "\n\nРазработчик приложения - t.me/DubsCat"
                    text_view_catast.movementMethod = LinkMovementMethod.getInstance()
                    MainInfo.savedCatastText = text_view_catast.text.toString() }
                .setNeutralButton("Нет",null) .create().show()
        }

    }

}
