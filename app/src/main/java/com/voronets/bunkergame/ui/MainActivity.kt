package com.voronets.bunkergame.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.voronets.bunkergame.R
import com.voronets.bunkergame.utils.Constants
import com.voronets.bunkergame.utils.GameRules

import kotlinx.android.synthetic.main.activity_main.*


/**
 * Main Activity with fragment manager
 */

class MainActivity : AppCompatActivity() {
    private lateinit var mAdView : AdView
    private lateinit var mInterstitialAd:InterstitialAd
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAds()
        setNavigation()
        GameRules.showRules(this)
    }


    private fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
    }

    private fun setAds(){
        val requestConfiguration = MobileAds.getRequestConfiguration()
            .toBuilder()
            .build()
        MobileAds.setRequestConfiguration(requestConfiguration)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = Constants.google_ads_token
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.")
        }
    }

    private fun setNavigation(){
        val heroFragment = HeroFragment()
        val catastFragment = CatastFragment()

        supportFragmentManager.beginTransaction().replace(R.id.main_fragment, heroFragment).commit()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btn_fr_hero -> {setCurrentFragment(heroFragment)
                }
                R.id.btn_fr_cat -> {setCurrentFragment(catastFragment)
                }
            }
            true
        }
    }
    }