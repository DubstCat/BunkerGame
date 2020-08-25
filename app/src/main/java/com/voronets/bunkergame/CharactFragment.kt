package com.voronets.bunkergame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_charact.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class CharactFragment : Fragment(R.layout.fragment_charact) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        text_view_charact.text = Characts.savedCharactsText

        button_сharact.setOnClickListener{
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
        super.onViewCreated(view, savedInstanceState)
    }
}


