package com.voronets.bunkergame.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.voronets.bunkergame.Adapters.CharactAdapter
import com.voronets.bunkergame.DataClasses.MainInfo
import com.voronets.bunkergame.DataClasses.CharactItem
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.fragment_hero.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class HeroFragment : Fragment(R.layout.fragment_hero) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter:CharactAdapter? = CharactAdapter(listOf())
        RV_Characteristics.layoutManager = LinearLayoutManager(context)
        RV_Characteristics.adapter = adapter

        if (MainInfo.savedHeroes !=null){
            RV_Characteristics.layoutManager = LinearLayoutManager(context)
            adapter = CharactAdapter(MainInfo.savedHeroes!!)
            adapter.notifyItemInserted(MainInfo.savedHeroes!!.size-1)
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
            CharactItem(
                Name = "Пол:",
                Description = arrayListOf("мужской", "женский").shuffled()[0]
            ),
            CharactItem(
                Name = "Возраст:",
                Description = Random.nextInt(18, 100).toString()
            ),
            CharactItem(
                Name = "Профессия",
                Description = MainInfo.professions.shuffled()[0]
            ),
            CharactItem(
                Name = "Способность к деторождению",
                Description = MainInfo.reproduction.shuffled()[0]
            ),
            CharactItem(
                Name = "Состояние здоровья",
                Description = MainInfo.health.shuffled()[0]
            ),
            CharactItem(
                Name = "Телосложение",
                Description = MainInfo.body.shuffled()[0]
            ),
            CharactItem(
                Name = "Фобии",
                Description = MainInfo.fear.shuffled()[0]
            ),
            CharactItem(
                Name = "Хобби",
                Description = MainInfo.hobby.shuffled()[0]
            ),
            CharactItem(
                Name = "Черты характера",
                Description = MainInfo.character.shuffled()[0]
            ),
            CharactItem(
                Name = "Доп инфа",
                Description = MainInfo.extra_info.shuffled()[0]
            ),
            CharactItem(
                Name = "Багаж",
                Description = MainInfo.bag.shuffled()[0]
            ),
            CharactItem(
                Name = "Карта №1",
                Description = MainInfo.actions.shuffled()[0]
            ),
            CharactItem(
                Name = "Карта №2",
                Description = MainInfo.actions.shuffled()[0]
            )
        )

        RV_Characteristics.layoutManager = LinearLayoutManager(context)
        val adapter =
            CharactAdapter(CharactList)
        adapter.notifyItemInserted(CharactList.size-1)
        RV_Characteristics.adapter = adapter

        MainInfo.savedHeroes =CharactList
    }
}
