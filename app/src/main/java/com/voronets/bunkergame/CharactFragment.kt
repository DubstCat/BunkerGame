package com.voronets.bunkergame

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_charact.*


/**
 * A simple [Fragment] subclass.
 */
class CharactFragment : Fragment(R.layout.fragment_charact) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        text_view_charact.text = Characts.savedCharactsText

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
        text_view_charact.text = "Профессия: ${Characts.professions.shuffled()[0]}\n\n" +
                "Способность к деторождению: ${Characts.detorozhd.shuffled()[0]}\n\n" +
                "Состояние здоровья: ${Characts.health.shuffled()[0]}\n\n" +
                "Телосложение: ${Characts.body.shuffled()[0]}\n\n" +
                "Фобии: ${Characts.fobii.shuffled()[0]}\n\n" +
                "Хобби: ${Characts.hobby.shuffled()[0]}\n\n" +
                "Черты характера: ${Characts.harakter.shuffled()[0]}\n\n" +
                "Доп. инфа: ${Characts.dopinfa.shuffled()[0]}\n\n" +
                "Багаж: ${Characts.bagazh.shuffled()[0]}\n\n"
        Characts.savedCharactsText = text_view_charact.text.toString()
    }
}
