package com.voronets.bunkergame.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.voronets.bunkergame.DataClasses.HeroSingleton
import com.voronets.bunkergame.GameRules
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.fragment_catast.*
import kotlin.random.Random

/**
 * A [Fragment] for displaying game situation info.
 */
class CatastFragment : Fragment(R.layout.fragment_catast) {
    val KEY_CATAST_MAP = "KEY_CATAST_MAP"
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListeners()
        if (HeroSingleton.savedCatast==null){
            generateCatast()
        }else
            setCatastText(HeroSingleton.savedCatast)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    private fun setCatastText(catastMap: HashMap<String, String>?){

        Log.d("TAG", ""+catastMap)
        for ((key) in catastMap!!.entries) {
            text_view_catast_title.text = key
        }
        text_view_catast.text = catastMap[text_view_catast_title.text.toString()]
    }

    @SuppressLint("SetTextI18n")
    private fun bindListeners(){
        btn_generate_catast.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle(getString(R.string.catast_generation))
                .setMessage(getString(R.string.catastrophe_dialog))
                .setPositiveButton(getString(R.string.yes)) { _, _ ->
                    generateCatast()
                }
                .setNeutralButton(getString(R.string.No),null) .create().show()
        }
        btn_generate_catast.setOnLongClickListener{
            GameRules.showRules(context!!)
            true
        }
    }

    fun generateCatast(){
        val catastTitles = context?.resources?.getStringArray(R.array.catast_titles)?.toList()
        val catastDescriptions = context?.resources?.getStringArray(R.array.catast_descriptions)?.toList()
        text_view_catast_title.text = catastTitles!!.shuffled()[0]
        text_view_catast.text = catastDescriptions!![catastTitles.indexOf(element = text_view_catast_title.text.toString())]+
                getString(R.string.time_in_bunker) +" "+ Random.nextInt(1,50) +" "+ getString(R.string.years)+
                getString(R.string.food_and_water_remain) +" "+ Random.nextInt(1, 50) +" "+ getString(R.string.years)+
                getString(R.string.bunker_extra) +" "+ resources.getStringArray(R.array.bonus_items).toList().shuffled()[0]
        text_view_catast.movementMethod = LinkMovementMethod.getInstance()
        HeroSingleton.savedCatast = hashMapOf(text_view_catast_title.text.toString() to text_view_catast.text.toString())
    }
}
