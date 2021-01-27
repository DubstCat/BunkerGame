package com.voronets.bunkergame.Fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.voronets.bunkergame.Controllers.CharactItemController
import com.voronets.bunkergame.Controllers.HeroLogic
import com.voronets.bunkergame.DataClasses.CharactItem
import com.voronets.bunkergame.DataClasses.HeroSingleton
import com.voronets.bunkergame.GameRules
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.characteristics_layout.view.*
import kotlinx.android.synthetic.main.fragment_hero.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */

class HeroFragment : Fragment(R.layout.fragment_hero), HeroLogic {

    val KEY_CHARACT_LIST = "KEY_CHARACT_LIST"
    lateinit var mNames:Array<Int>
    lateinit var mDescriptions:Array<Any>
    var mCharactList: ArrayList<CharactItem>?=null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateLists()
        if(HeroSingleton.savedHero!=null)
            mCharactList = HeroSingleton.savedHero
        else {
            createHero()
        }
        bindListeners()
        bindRecyclerView()

    }
    private fun bindRecyclerView(){
            RV_Characteristics.layoutManager = LinearLayoutManager(context)
            val adapter = CharactAdapter(mCharactList!!.toMutableList())
            adapter.atachView(RV_Characteristics)
            adapter.notifyItemInserted(mCharactList!!.size-1)
            RV_Characteristics.adapter = adapter
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
                .setTitle(getString(R.string.hero_generation))
                .setMessage(getString(R.string.hero_regeneration))
                .setPositiveButton(getString(R.string.yes)) { _, _ -> createHero() }
                .setNeutralButton(getString(R.string.No),null) .create().show()
        }
        btn_generate_hero.setOnLongClickListener{
            GameRules.showRules(context!!)
            true
        }
    }
    override fun createHero(){
        updateLists()
        mCharactList = arrayListOf<CharactItem>()
        for(i in mNames.indices)
            mCharactList!!.add(CharactItem(name = getString(mNames[i]),description = mDescriptions[i].toString()))

        RV_Characteristics.layoutManager = LinearLayoutManager(context)
        val adapter =
            CharactAdapter(mCharactList!!)
        adapter.atachView(RV_Characteristics)
        bindRecyclerView()
    }

    inner class CharactAdapter (
        private var charactItems:MutableList<CharactItem>
    ):RecyclerView.Adapter<CharactAdapter.CharactViewHolder>(), CharactItemController {

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
                val context = this@HeroFragment
                if (it.tv_charact_name.text!=context.resources.getString(R.string.action_1) && it.tv_charact_name.text!=context.resources.getString(R.string.action_2))
                    AlertDialog.Builder(it.context)
                        .setTitle(getString(R.string.regeneration))
                        .setMessage(getString(R.string.charact_regeneration)+"${it.tv_charact_name.text}"+"?")
                        .setPositiveButton(getString(R.string.yes)) { _, _ -> rerollCharact(v = it, pos = position)}
                        .setNeutralButton(getString(R.string.No), null).create().show()
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
                        mCharactList?.clear()
                        mCharactList?.addAll(charactItems)

                    }else{
                        charactItems[position] = CharactItem(
                            name = charactItems[position].name,
                            description = charactItems[position].description,
                            isActivated = false
                        )
                        mCharactList?.clear()
                        mCharactList?.addAll(charactItems)
                    }
                    mRecyclerView!!.adapter!!.notifyItemInserted(mCharactList!!.size-1)
                    notifyDataSetChanged()

                    HeroSingleton.savedHero = mCharactList
                    true
                }
            }
        }
        override fun getItemViewType(position: Int): Int {
            return 0
        }
        override fun rerollCharact(v: View, pos: Int) {
            updateLists()
            charactItems[pos].description = mDescriptions[pos].toString()
            mRecyclerView!!.adapter!!.notifyDataSetChanged()
            HeroSingleton.savedHero = mCharactList
        }
        fun atachView(RV:RecyclerView){
            this.mRecyclerView = RV
        }
    }
    fun updateLists(){
        mNames = arrayOf(R.string.gender, R.string.age, R.string.profession, R.string.fertility, R.string.orientation, R.string.health,
            R.string.body, R.string.fear, R.string.hobby, R.string.character, R.string.extra_info, R.string.bag,
            R.string.action_1, R.string.action_2)
        mDescriptions = arrayOf(
            resources.getStringArray(R.array.gender).toList().shuffled()[0],
            Random.nextInt(18, 100).toString(),
            resources.getStringArray(R.array.professions).toList().shuffled()[0],
            resources.getStringArray(R.array.reproduction).toList().shuffled()[0],
            resources.getStringArray(R.array.orientation).toList().shuffled()[0],
            resources.getStringArray(R.array.health).toList().shuffled()[0]+" "+ Random.nextInt(10,100)+"%",
            resources.getStringArray(R.array.body).toList().shuffled()[0],
            resources.getStringArray(R.array.fear).toList().shuffled()[0],
            resources.getStringArray(R.array.hobby).toList().shuffled()[0],
            resources.getStringArray(R.array.character).toList().shuffled()[0],
            resources.getStringArray(R.array.extra_info).toList().shuffled()[0],
            resources.getStringArray(R.array.bag).toList().shuffled()[0],
            resources.getStringArray(R.array.actions).toList().shuffled()[0],
            resources.getStringArray(R.array.actions).toList().shuffled()[0]
        )
    }
}
