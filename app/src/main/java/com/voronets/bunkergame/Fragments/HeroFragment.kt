package com.voronets.bunkergame.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.voronets.bunkergame.Adapters.CharactAdapter
import com.voronets.bunkergame.Controllers.HeroLogic
import com.voronets.bunkergame.DataClasses.CharactItem
import com.voronets.bunkergame.DataClasses.MainInfo
import com.voronets.bunkergame.MainActivity
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.fragment_hero.*
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 */

class HeroFragment : Fragment(R.layout.fragment_hero), HeroLogic {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListeners()
        bindRecyclerView()
    }

    private fun bindRecyclerView(){
        if (MainInfo.savedHeroes !=null){
            RV_Characteristics.layoutManager = LinearLayoutManager(context)
            val adapter = CharactAdapter(MainInfo.savedHeroes!!)
            adapter.atachView(RV_Characteristics)
            adapter.notifyItemInserted(MainInfo.savedHeroes!!.size-1)
            RV_Characteristics.adapter = adapter
        }
    }

    private fun bindListeners(){
        RV_Characteristics.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            private var isScrolledDown = false
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_SETTLING && isScrolledDown) { // Do something...
                    btn_generate_hero.hide()

                }
                if (newState == RecyclerView.SCROLL_STATE_SETTLING && !isScrolledDown) { // Do something...
                    btn_generate_hero.show()
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                isScrolledDown = dy > 0
            }
        })

        btn_generate_hero.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle("Генерация персонажа")
                .setMessage("Вы уверены, что хотите cгенерировать персонажа?")
                .setPositiveButton("Да") { _, _ -> createHero() }
                .setNeutralButton("Нет",null) .create().show()
        }
        btn_generate_hero.setOnLongClickListener{
            AlertDialog.Builder(context)
                .setTitle("Правила игры")
                .setMessage(getString(R.string.rules_text))
                .setPositiveButton("Окей", null)
                .create()
                .show()
            true
        }

    }

    override fun createHero(){
        val CharactList = mutableListOf(
            CharactItem(
                name = "Пол",
                description = arrayListOf("мужской", "женский").shuffled()[0]
            ),
            CharactItem(
                name = "Возраст",
                description = Random.nextInt(18, 100).toString()
            ),
            CharactItem(
                name = "Профессия",
                description = MainInfo.professions.shuffled()[0]
            ),
            CharactItem(
                name = "Фертильность",
                description = MainInfo.reproduction.shuffled()[0]
            ),
            CharactItem(
                name = "Ориентация",
                description =  MainInfo.orientation.shuffled()[0]
            ),
            CharactItem(
                name = "Состояние здоровья",
                description = MainInfo.health.shuffled()[0]+" "+ Random.nextInt(10,100)+"%"
            ),
            CharactItem(
                name = "Телосложение",
                description = MainInfo.body.shuffled()[0]
            ),
            CharactItem(
                name = "Фобии",
                description = MainInfo.fear.shuffled()[0]
            ),
            CharactItem(
                name = "Хобби",
                description = MainInfo.hobby.shuffled()[0]
            ),
            CharactItem(
                name = "Черты характера",
                description = MainInfo.character.shuffled()[0]
            ),
            CharactItem(
                name = "Дополнительно",
                description = MainInfo.extra_info.shuffled()[0]
            ),
            CharactItem(
                name = "Багаж",
                description = MainInfo.bag.shuffled()[0]
            ),
            CharactItem(
                name = "Карта №1",
                description = MainInfo.actions.shuffled()[0]
            ),
            CharactItem(
                name = "Карта №2",
                description = MainInfo.actions.shuffled()[0]
            )
        )

        RV_Characteristics.layoutManager = LinearLayoutManager(context)
        val adapter =
            CharactAdapter(CharactList)
        adapter.atachView(RV_Characteristics)
        adapter.notifyItemInserted(CharactList.size-1)
        RV_Characteristics.adapter = adapter

        MainInfo.savedHeroes = CharactList
    }

}
