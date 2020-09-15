package com.voronets.bunkergame.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voronets.bunkergame.DataClasses.CharactItem
import com.voronets.bunkergame.R
import kotlinx.android.synthetic.main.characteristics_layout.view.*

/**
 * Adapter for characteristics in Heroes Recycler View
 */

class CharactAdapter (
    private var charactItems:List<CharactItem>
):RecyclerView.Adapter<CharactAdapter.CharactViewHolder>(){
    private var backgroundsList = listOf<Int>(
        R.drawable.bg_text_red,
        R.drawable.bg_text_orange,
        R.drawable.bg_text_orange,
        R.drawable.bg_text_green,
        R.drawable.bg_text_cyan,
        R.drawable.bg_text_blue,
        R.drawable.bg_text_purple
    )

    inner class CharactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characteristics_layout, parent, false)
        return CharactViewHolder(view)
    }
    override fun getItemCount(): Int = charactItems.size

    override fun onBindViewHolder(holder: CharactViewHolder, position: Int) {
        holder.itemView.apply {
            tv_charact_name.text = charactItems[position].Name
            tv_charact_description.text = charactItems[position].Description
            tv_charact_description.background = resources.getDrawable(backgroundsList.shuffled()[0])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }}
