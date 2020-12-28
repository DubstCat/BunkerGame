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
            val context = mRecyclerView!!.context
            if (it.tv_charact_name.text!=context.resources.getString(R.string.action_1) && it.tv_charact_name.text!=context.resources.getString(R.string.action_2))
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
        var context = mRecyclerView!!.context
        for(i in charactItems.indices)
        when(v.tv_charact_name.text){
            context.getString(R.string.gender) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.gender).toList().shuffled()[0]
                                MainInfo.savedHeroes!![0].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.age) -> {v.tv_charact_description.text = Random.nextInt(18,100).toString()
                                MainInfo.savedHeroes!![1].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.profession) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.professions).toList().shuffled()[0]
                                MainInfo.savedHeroes!![2].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.fertility) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.reproduction).toList().shuffled()[0]
                                MainInfo.savedHeroes!![3].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.orientation) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.orientation).toList().shuffled()[0]
                                MainInfo.savedHeroes!![4].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.health)-> {v.tv_charact_description.text = context.resources.getStringArray(R.array.health).toList().shuffled()[0]+" "+ Random.nextInt(10,100)+"%"
                                MainInfo.savedHeroes!![5].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.hobby) ->{v.tv_charact_description.text = context.resources.getStringArray(R.array.hobby).toList().shuffled()[0]
                                MainInfo.savedHeroes!![6].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.body) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.body).toList().shuffled()[0]
                                MainInfo.savedHeroes!![7].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.fear) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.fear).toList().shuffled()[0]
                                MainInfo.savedHeroes!![8].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.character) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.character).toList().shuffled()[0]
                                MainInfo.savedHeroes!![9].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.extra_info) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.extra_info).toList().shuffled()[0]
                                MainInfo.savedHeroes!![10].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.bag) -> {v.tv_charact_description.text = context.resources.getStringArray(R.array.bag).toList().shuffled()[0]
                                MainInfo.savedHeroes!![11].description = v.tv_charact_description.text.toString()
            }

            context.getString(R.string.action_1)->{
                v.tv_charact_description.text = context.resources.getStringArray(R.array.actions).toList().shuffled()[0]
                MainInfo.savedHeroes!![12].description = v.tv_charact_description.text.toString()
            }
            context.getString(R.string.action_2) -> {
                v.tv_charact_description.text = context.resources.getStringArray(R.array.actions).toList().shuffled()[0]
                MainInfo.savedHeroes!![13].description = v.tv_charact_description.text.toString()
            }
        }
        MainInfo.savedHeroes = charactItems
    }
    fun atachView(RV:RecyclerView){
        this.mRecyclerView = RV
    }


}
