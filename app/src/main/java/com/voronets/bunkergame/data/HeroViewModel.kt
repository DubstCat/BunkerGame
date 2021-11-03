package com.voronets.bunkergame.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.voronets.bunkergame.R
import kotlin.random.Random

/**
 * ViewModel for getting character data
 */

class HeroViewModel(context: Application) : AndroidViewModel(context) {
    val resources = context.resources

    var mCharactList = MutableLiveData<MutableList<CharactItem>>()

    val mNames = arrayOf(
        resources.getString(R.string.gender),
        resources.getString(R.string.age),
        resources.getString(R.string.profession),
        resources.getString(R.string.fertility),
        resources.getString(R.string.orientation),
        resources.getString(R.string.health),
        resources.getString(R.string.body),
        resources.getString(R.string.fear),
        resources.getString(R.string.hobby),
        resources.getString(R.string.character),
        resources.getString(R.string.extra_info),
        resources.getString(R.string.bag),
        resources.getString(R.string.action_1),
        resources.getString(R.string.action_2)
    )

    var mDescriptions: Array<String> = arrayOf()

    fun rerollCharact(pos:Int){
        val newItem = CharactItem(mNames[pos],updateDesriptions()[pos])
        val list = mCharactList.value
        list?.set(pos, newItem)
        mCharactList.value = list
    }

    fun createHero() {
        mDescriptions = updateDesriptions()
        val list:MutableList<CharactItem> = arrayListOf()
        for (i in mNames.indices)
            list.add(
                CharactItem(
                    name = mNames[i],
                    description = mDescriptions[i]
                )
            )
        mCharactList.value = list
    }


    init {
        mDescriptions = updateDesriptions()
        createHero()
    }

    fun setActivated(pos:Int){
        val list = mCharactList.value
        list!![pos].isActivated = !list[pos].isActivated
        mCharactList.value = list
    }

    fun updateDesriptions() = arrayOf(
            resources.getStringArray(R.array.gender).toList().shuffled()[0],
            Random.nextInt(18, 100).toString(),
            resources.getStringArray(R.array.professions).toList().shuffled()[0],
            resources.getStringArray(R.array.reproduction).toList().shuffled()[0],
            resources.getStringArray(R.array.orientation).toList().shuffled()[0],
            resources.getStringArray(R.array.health).toList().shuffled()[0] + " " + Random.nextInt(
                10,
                100
            ) + "%",
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
