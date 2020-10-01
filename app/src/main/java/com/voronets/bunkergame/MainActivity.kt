package com.voronets.bunkergame

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.voronets.bunkergame.Fragments.CatastFragment
import com.voronets.bunkergame.Fragments.HeroFragment
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Main Activity with fragment manager
 */

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val heroFragment = HeroFragment()
        val catastFragment = CatastFragment()

        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, heroFragment).commit()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btn_fr_hero -> setCurrentFragment(heroFragment)
                R.id.btn_fr_cat -> setCurrentFragment(catastFragment)
                }
            true
            }
        }

    fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
    }
    }
