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
                name = getString(R.string.gender),
                description = resources.getStringArray(R.array.gender).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.age),
                description = Random.nextInt(18, 100).toString()
            ),
            CharactItem(
                name = getString(R.string.profession),
                description = resources.getStringArray(R.array.professions).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.fertility),
                description = resources.getStringArray(R.array.reproduction).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.orientation),
                description =  resources.getStringArray(R.array.orientation).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.health),
                description = resources.getStringArray(R.array.health).toList().shuffled()[0]+" "+ Random.nextInt(10,100)+"%"
            ),
            CharactItem(
                name = getString(R.string.body),
                description = resources.getStringArray(R.array.body).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.fear),
                description = resources.getStringArray(R.array.fear).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.hobby),
                description = resources.getStringArray(R.array.hobby).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.character),
                description = resources.getStringArray(R.array.character).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.extra_info),
                description = resources.getStringArray(R.array.extra_info).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.bag),
                description = resources.getStringArray(R.array.bag).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.action_1),
                description = resources.getStringArray(R.array.actions).toList().shuffled()[0]
            ),
            CharactItem(
                name = getString(R.string.action_2),
                description = resources.getStringArray(R.array.actions).toList().shuffled()[0]
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
