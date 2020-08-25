package com.voronets.bunkergame

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heroFragment = HeroFragment()
        val charactFragment = CharactFragment()
        val catastFragment = CatastFragment()

        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, catastFragment).commit()


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btn_fr_hero -> setCurrentFragment(heroFragment)
                R.id.btn_fr_charact -> setCurrentFragment(charactFragment)
                R.id.btn_fr_cat -> setCurrentFragment(catastFragment)
                }
            true
            }
        }

    fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
    }
    }



