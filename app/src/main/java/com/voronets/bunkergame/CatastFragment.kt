package com.voronets.bunkergame

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_catast.*


/**
 * A simple [Fragment] subclass.
 */
class CatastFragment : Fragment(R.layout.fragment_catast) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_view_catast.text = Characts.savedCatastText

        button_catast.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle("Перегенерация катастрофы")
                .setMessage("Вы уверены, что хотите перегенерировать катастрофу?")
                .setPositiveButton("Да") { _, _ ->
                    text_view_catast.text = Characts.catast.shuffled()[0]
                    Characts.savedCatastText = text_view_catast.text.toString() }
                .setNegativeButton("Нет",null) .create().show()
        }

    }

}
