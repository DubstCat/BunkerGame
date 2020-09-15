package com.voronets.bunkergame.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.voronets.bunkergame.DataClasses.MainInfo
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.fragment_charact.*


/**
 * A simple [Fragment] subclass.
 */
class CharactFragment : Fragment(R.layout.fragment_charact) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        text_view_charact.text =
            MainInfo.savedCharactsText

        button_сharact.setOnClickListener{

            AlertDialog.Builder(context)
                .setTitle("Перегенерация характеристик")
                .setMessage("Вы уверены, что хотите перегенерировать характеристики?")
                .setPositiveButton("Да") { _, _ -> setCharactText() }
                .setNegativeButton("Нет",null) .create().show()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setCharactText(){
        text_view_charact.text = "Профессия: ${MainInfo.professions.shuffled()[0]}\n\n" +
                "Способность к деторождению: ${MainInfo.reproduction.shuffled()[0]}\n\n" +
                "Состояние здоровья: ${MainInfo.health.shuffled()[0]}\n\n" +
                "Телосложение: ${MainInfo.body.shuffled()[0]}\n\n" +
                "Фобии: ${MainInfo.fear.shuffled()[0]}\n\n" +
                "Хобби: ${MainInfo.hobby.shuffled()[0]}\n\n" +
                "Черты характера: ${MainInfo.character.shuffled()[0]}\n\n" +
                "Доп. инфа: ${MainInfo.extra_info.shuffled()[0]}\n\n" +
                "Багаж: ${MainInfo.bag.shuffled()[0]}\n\n"
        MainInfo.savedCharactsText = text_view_charact.text.toString()
    }
}
