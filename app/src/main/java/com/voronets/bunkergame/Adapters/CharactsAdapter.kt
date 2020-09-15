package com.voronets.bunkergame.Adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voronets.bunkergame.Controllers.CharactItemController
import com.voronets.bunkergame.DataClasses.CharactItem
import com.voronets.bunkergame.DataClasses.MainInfo
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.characteristics_layout.view.*

/**
 * Adapter for characteristics in Heroes Recycler View
 */

class CharactAdapter (
    private var charactItems:MutableList<CharactItem>
):RecyclerView.Adapter<CharactAdapter.CharactViewHolder>(), CharactItemController{
    private var backgroundsList = listOf<Int>(
        R.drawable.bg_text_red,
        R.drawable.bg_text_orange,
        R.drawable.bg_text_green,
        R.drawable.bg_text_cyan,
        R.drawable.bg_text_blue,
        R.drawable.bg_text_purple
    )
    private lateinit var mRecyclerView:RecyclerView

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
                .setNegativeButton("Нет", null).create().show()
        }

        holder.itemView.apply {
            tv_charact_name.text = charactItems[position].name
            tv_charact_description.text = charactItems[position].description
            tv_charact_description.background = resources.getDrawable(backgroundsList.shuffled()[0])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun rerollCharact(v: View) {
        when(v.tv_charact_name.text){
            "Профессия" -> v.tv_charact_description.text = MainInfo.professions.shuffled()[0]
            "Состояние здоровья" -> v.tv_charact_description.text = MainInfo.health.shuffled()[0]
            "Фобии" -> v.tv_charact_description.text = MainInfo.fear.shuffled()[0]
            "Багаж" -> v.tv_charact_description.text = MainInfo.bag.shuffled()[0]
            "Карта №1"->{
                charactItems.remove(
                    CharactItem(name = v.tv_charact_name.text.toString(), description = v.tv_charact_description.text.toString())
                )
                mRecyclerView.adapter!!.notifyDataSetChanged()
            }
            "Карта №2" -> {
                charactItems.remove(
                    CharactItem(name = v.tv_charact_name.text.toString(), description = v.tv_charact_description.text.toString())
                )
                mRecyclerView.adapter!!.notifyDataSetChanged()
            }
        }

    }
    fun atachView(RV:RecyclerView){
        this.mRecyclerView = RV
    }
}
