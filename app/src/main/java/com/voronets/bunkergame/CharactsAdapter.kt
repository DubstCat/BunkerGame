package com.voronets.bunkergame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.characteristics_layout.view.*


class CharactAdapter (
    private var characts:List<Charact>
):RecyclerView.Adapter<CharactAdapter.CharactViewHolder>(){
    private var backgroundsList = listOf<Int>(
        R.drawable.bg_text_red,
        R.drawable.bg_text_orange,
        R.drawable.bg_text_orange ,
        R.drawable.bg_text_green,
        R.drawable.bg_text_cyan,
        R.drawable.bg_text_blue ,
        R.drawable.bg_text_purple)

    inner class CharactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characteristics_layout, parent, false)
        return CharactViewHolder(view)
    }
    override fun getItemCount(): Int = characts.size

    override fun onBindViewHolder(holder: CharactViewHolder, position: Int) {
        holder.itemView.apply {
            tv_charact_name.text = characts[position].Name
            tv_charact_description.text = characts[position].Description
            tv_charact_description.background = resources.getDrawable(backgroundsList.shuffled()[0])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }}