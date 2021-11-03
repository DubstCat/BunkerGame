package com.voronets.bunkergame.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.voronets.bunkergame.utils.GameRules
import com.voronets.bunkergame.data.HeroViewModel
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.characteristics_layout.view.*
import kotlinx.android.synthetic.main.fragment_hero.*

/**
 * A simple [Fragment] subclass.
 */

class HeroFragment : Fragment(R.layout.fragment_hero) {
    lateinit var model: HeroViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RV_Characteristics.layoutManager = LinearLayoutManager(context)
        val adapter = CharactAdapter()
        RV_Characteristics.adapter = adapter

        model = ViewModelProvider(requireActivity()).get(HeroViewModel::class.java)
        model.mCharactList.observe(requireActivity(), Observer {
            adapter.notifyDataSetChanged()
        })

        bindListeners()
    }


    private fun bindListeners() {
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

        btn_generate_hero.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle(getString(R.string.hero_generation))
                .setMessage(getString(R.string.hero_regeneration))
                .setPositiveButton(getString(R.string.yes)) { _, _ -> model.createHero() }
                .setNeutralButton(getString(R.string.No), null).create().show()
        }
        btn_generate_hero.setOnLongClickListener {
            GameRules.showRules(requireContext())
            true
        }
    }


    inner class CharactAdapter
        : RecyclerView.Adapter<CharactAdapter.CharactViewHolder>() {
        inner class CharactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.characteristics_layout, parent, false)
            return CharactViewHolder(view)
        }

        override fun getItemCount(): Int = model.mCharactList.value?.size!!

        @SuppressLint("UseCompatLoadingForDrawables")
        override fun onBindViewHolder(holder: CharactViewHolder, position: Int) {
            holder.itemView.apply {

                setOnClickListener {
                    if (isNotAnAction(it))
                        showRerollDialog(it, position)
                }

                setCharactData(this, position)
                changeViewIfActivated(this, !model.mCharactList.value?.get(position)?.isActivated!!)
                setOnLongClickListener {
                    model.setActivated(position)
                    true
                }
            }
        }

        override fun getItemViewType(position: Int): Int {
            return 0
        }

        fun rerollCharact(pos: Int) {
            model.rerollCharact(pos)
        }

        fun setCharactData(itemView: View, position: Int) {
            itemView.apply {
                tv_charact_name.text = model.mCharactList.value?.get(position)!!.name
                tv_charact_description.text = model.mCharactList.value?.get(position)!!.description
            }
        }

        fun showRerollDialog(itemView: View, position: Int){
            AlertDialog.Builder(itemView.context)
                .setTitle(getString(R.string.regeneration))
                .setMessage(getString(R.string.charact_regeneration) + "${itemView.tv_charact_name.text}" + "?")
                .setPositiveButton(getString(R.string.yes)) { _, _ ->
                    rerollCharact(position)
                }
                .setNeutralButton(getString(R.string.No), null).create().show()
        }

        fun isNotAnAction(itemView: View) = itemView.tv_charact_name.text != context?.resources?.getString(R.string.action_1)
                                            &&
                                            itemView.tv_charact_name.text != context?.resources?.getString(R.string.action_2)

        fun changeViewIfActivated(itemView: View, isActivated: Boolean) {
            itemView.apply {
                if (isActivated) {
                    tv_charact_name.setTextColor(Color.parseColor("#4a4a4a"))
                    tv_charact_description.background =
                        resources.getDrawable(R.drawable.bg_text_dark)
                } else {
                    tv_charact_name.setTextColor(Color.parseColor("#604a4a4a"))
                    tv_charact_description.background =
                        resources.getDrawable(R.drawable.bg_text_light)
                }
            }
        }
    }
}
