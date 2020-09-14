package com.voronets.bunkergame

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hero.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class HeroFragment : Fragment(R.layout.fragment_hero) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Characts.savedHero!=null){
            RV_Characteristics.layoutManager = LinearLayoutManager(context)
            val adapter = CharactAdapter(Characts.savedHero!!)
            adapter.notifyItemInserted(Characts.savedHero!!.size-1)
            RV_Characteristics.adapter = adapter
        }


        button_hero.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle("Перегенерация персонажа")
                .setMessage("Вы уверены, что хотите перегенерировать персонажа?")
                .setPositiveButton("Да") { _, _ -> createHero() }
                .setNegativeButton("Нет",null) .create().show()

        }
    }

    private fun createHero(){

        val CharactList = listOf(
            Charact(Name = "Пол:", Description = arrayListOf("мужской","женский").shuffled()[0]),
            Charact(Name = "Возраст:", Description = Random.nextInt(18,100).toString()),
            Charact(Name = "Профессия", Description = Characts.professions.shuffled()[0]),
            Charact(Name = "Способность к деторождению", Description = Characts.reproduction.shuffled()[0]),
            Charact(Name = "Состояние здоровья", Description = Characts.health.shuffled()[0]),
            Charact(Name = "Телосложение", Description = Characts.body.shuffled()[0]),
            Charact(Name = "Фобии", Description = Characts.fear.shuffled()[0]),
            Charact(Name = "Хобби", Description = Characts.hobby.shuffled()[0]),
            Charact(Name = "Черты характера", Description = Characts.character.shuffled()[0]),
            Charact(Name = "Доп инфа", Description = Characts.extra_info.shuffled()[0]),
            Charact(Name = "Багаж", Description = Characts.bag.shuffled()[0]),
            Charact(Name = "Карта №1", Description = Characts.actions.shuffled()[0]),
            Charact(Name = "Карта №2", Description = Characts.actions.shuffled()[0])
        )

        RV_Characteristics.layoutManager = LinearLayoutManager(context)
        val adapter = CharactAdapter(CharactList)
        adapter.notifyItemInserted(CharactList.size-1)
        RV_Characteristics.adapter = adapter

        Characts.savedHero=CharactList
    }
}
