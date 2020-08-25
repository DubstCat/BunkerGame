package com.voronets.bunkergame

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_hero.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class HeroFragment : Fragment(R.layout.fragment_hero) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_view_hero.movementMethod = ScrollingMovementMethod()
        text_view_hero.text = Characts.savedHeroText
        button_hero.setOnClickListener{
            createHero()
        }
    }

    private fun createHero(){
        //text_view_hero.setTextSize(17f)
        text_view_hero.text = "Пол: ${arrayListOf<String>("мужской","женский").shuffled()[0]}\n\n" +
                "Возраст: ${Random.nextInt(18,100)}\n\n" +
                "Профессия: ${Characts.professions.shuffled()[0]}\n\n" +
                "Способность к деторождению: ${Characts.detorozhd.shuffled()[0]}\n\n" +
                "Состояние здоровья: ${Characts.health.shuffled()[0]}\n\n" +
                "Телосложение: ${Characts.body.shuffled()[0]}\n\n" +
                "Фобии: ${Characts.fobii.shuffled()[0]}\n\n" +
                "Хобби: ${Characts.hobby.shuffled()[0]}\n\n" +
                "Черты характера: ${Characts.harakter.shuffled()[0]}\n\n" +
                "Доп. инфа: ${Characts.dopinfa.shuffled()[0]}\n\n" +
                "Багаж: ${Characts.bagazh.shuffled()[0]}\n\n" +
                "Карта №1: ${Characts.deistvija.shuffled()[0]}\n\n" +
                "Карта №2: ${Characts.deistvija.shuffled()[0]}\n\n"

        Characts.savedHeroText=text_view_hero.text.toString()
    }
}


