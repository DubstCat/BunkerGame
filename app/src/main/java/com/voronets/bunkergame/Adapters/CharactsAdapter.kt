package com.voronets.bunkergame.Adapters

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voronets.bunkergame.Controllers.CharactItemController
import com.voronets.bunkergame.DataClasses.CharactItem
import com.voronets.bunkergame.DataClasses.MainInfo
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.characteristics_layout.view.*
import kotlinx.android.synthetic.main.fragment_hero.view.*
import kotlin.random.Random


/**
 * Adapter for characteristics in Heroes Recycler View
 */

class CharactAdapter (
    private var charactItems:MutableList<CharactItem>
):RecyclerView.Adapter<CharactAdapter.CharactViewHolder>(), CharactItemController{

    private var mRecyclerView:RecyclerView? = null

    inner class CharactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characteristics_layout, parent, false)
        return CharactViewHolder(view)
    }
    override fun getItemCount(): Int = charactItems.size

    override fun onBindViewHolder(holder: CharactViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            AlertDialog.Builder(it.context)
                .setTitle("Перегенерация")
                .setMessage("Вы уверены, что хотите перегенерировать характеристику \"${it.tv_charact_name.text}\"?")
                .setPositiveButton("Да") { _, _ -> rerollCharact(v = it)}
                .setNeutralButton("Нет", null).create().show()
        }



        holder.itemView.apply {
            tv_charact_name.text = charactItems[position].name
            tv_charact_description.text = charactItems[position].description

            if(!charactItems[position].isActivated) {
                tv_charact_name.setTextColor(Color.parseColor("#4a4a4a"))
                tv_charact_description.background = resources.getDrawable(R.drawable.bg_text_dark)
            }else{
                tv_charact_name.setTextColor(Color.parseColor("#604a4a4a"))
                tv_charact_description.background =
                    resources.getDrawable(R.drawable.bg_text_light)
            }

            setOnLongClickListener{
                if(!charactItems[position].isActivated) {
                    charactItems[position] = CharactItem(
                        name = charactItems[position].name,
                        description = charactItems[position].description,
                        isActivated = true
                    )
                    MainInfo.savedHeroes = charactItems
                }else{
                    charactItems[position] = CharactItem(
                        name = charactItems[position].name,
                        description = charactItems[position].description,
                        isActivated = false
                    )
                    MainInfo.savedHeroes = charactItems
                }
                MainInfo.savedHeroes = charactItems
                notifyDataSetChanged()
                true
            }

            }
        }


    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun rerollCharact(v: View) {
        for(i in charactItems.indices)
        when(v.tv_charact_name.text){
            "Профессия" -> {v.tv_charact_description.text = MainInfo.professions.shuffled()[0]
                            MainInfo.savedHeroes!![2].description = v.tv_charact_description.text.toString()}
            "Фертильность" -> {v.tv_charact_description.text = MainInfo.reproduction.shuffled()[0]
                                MainInfo.savedHeroes!![3].description = v.tv_charact_description.text.toString()}
            "Ориентация" -> {v.tv_charact_description.text = MainInfo.orientation.shuffled()[0]
                MainInfo.savedHeroes!![4].description = v.tv_charact_description.text.toString()
            }
            "Состояние здоровья" -> {v.tv_charact_description.text = MainInfo.health.shuffled()[0]+" "+ Random.nextInt(10,100)+"%"
                                MainInfo.savedHeroes!![5].description = v.tv_charact_description.text.toString()}
            "Хобби" ->{v.tv_charact_description.text = MainInfo.hobby.shuffled()[0]
                                MainInfo.savedHeroes!![6].description = v.tv_charact_description.text.toString()}
            "Телосложение" -> {v.tv_charact_description.text = MainInfo.body.shuffled()[0]
                                MainInfo.savedHeroes!![7].description = v.tv_charact_description.text.toString()}
            "Фобии" -> {v.tv_charact_description.text = MainInfo.fear.shuffled()[0]
                                MainInfo.savedHeroes!![8].description = v.tv_charact_description.text.toString()}
            "Черты характера" -> {v.tv_charact_description.text = MainInfo.character.shuffled()[0]
                                MainInfo.savedHeroes!![9].description = v.tv_charact_description.text.toString()}
            "Доп инфа" -> {v.tv_charact_description.text = MainInfo.extra_info.shuffled()[0]
                                MainInfo.savedHeroes!![10].description = v.tv_charact_description.text.toString()}
            "Багаж" -> {v.tv_charact_description.text = MainInfo.bag.shuffled()[0]
                                MainInfo.savedHeroes!![11].description = v.tv_charact_description.text.toString()}

            "Карта №1"->{
                charactItems.remove(
                    CharactItem(name = v.tv_charact_name.text.toString(), description = v.tv_charact_description.text.toString(),
                        isActivated = false)
                )
                charactItems.remove(
                    CharactItem(name = v.tv_charact_name.text.toString(), description = v.tv_charact_description.text.toString(),
                        isActivated = true)
                )
                mRecyclerView!!.adapter!!.notifyDataSetChanged()
            }
            "Карта №2" -> {
                charactItems.remove(
                    CharactItem(name = v.tv_charact_name.text.toString(), description = v.tv_charact_description.text.toString(),
                        isActivated = false)

                )
                charactItems.remove(
                    CharactItem(name = v.tv_charact_name.text.toString(), description = v.tv_charact_description.text.toString(),
                        isActivated = true)

                )
                    mRecyclerView!!.adapter!!.notifyDataSetChanged()
            }
        }
        MainInfo.savedHeroes = charactItems
    }
    fun atachView(RV:RecyclerView){
        this.mRecyclerView = RV
    }


}
