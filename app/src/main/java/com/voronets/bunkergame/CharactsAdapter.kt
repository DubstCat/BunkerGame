package com.voronets.bunkergame



import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.characteristics_layout.view.*
import org.w3c.dom.Attr

class CharactAdapter (

    private var characts:List<Charact>
):RecyclerView.Adapter<CharactAdapter.CharactViewHolder>(){
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



            /*tv_charact_description.setBackgroundColor(Color.parseColor(arrayListOf<String>
                (
                "#D40C00", "#FF5500", "#FFEF00", "#32C12C", "#526EFF", "#7F4FC9", "#00BCD9"
                ).shuffled()[0]))*/
            R.drawable.bg_characts_text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }}