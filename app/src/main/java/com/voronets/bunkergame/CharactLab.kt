package com.voronets.bunkergame

import android.content.Context
import com.voronets.bunkergame.DataClasses.CharactItem
import kotlin.random.Random

class CharactLab {
    private constructor(context: Context)
    lateinit var context:Context
    lateinit var mNames:Array<Int>
    lateinit var mDescriptions:Array<Any>
    lateinit var mCharactList:ArrayList<CharactItem>
    fun updateLists(){
        mNames = arrayOf(R.string.gender, R.string.age, R.string.profession, R.string.fertility, R.string.orientation, R.string.health,
            R.string.body, R.string.fear, R.string.hobby, R.string.character, R.string.extra_info, R.string.bag,
            R.string.action_1, R.string.action_2)
        mDescriptions = arrayOf(
            context.resources.getStringArray(R.array.gender).toList().shuffled()[0],
            Random.nextInt(18, 100).toString(),
            context.resources.getStringArray(R.array.professions).toList().shuffled()[0],
            context.resources.getStringArray(R.array.reproduction).toList().shuffled()[0],
            context.resources.getStringArray(R.array.orientation).toList().shuffled()[0],
            context.resources.getStringArray(R.array.health).toList().shuffled()[0]+" "+ Random.nextInt(10,100)+"%",
            context.resources.getStringArray(R.array.body).toList().shuffled()[0],
            context.resources.getStringArray(R.array.fear).toList().shuffled()[0],
            context.resources.getStringArray(R.array.hobby).toList().shuffled()[0],
            context.resources.getStringArray(R.array.character).toList().shuffled()[0],
            context.resources.getStringArray(R.array.extra_info).toList().shuffled()[0],
            context.resources.getStringArray(R.array.bag).toList().shuffled()[0],
            context.resources.getStringArray(R.array.actions).toList().shuffled()[0],
            context.resources.getStringArray(R.array.actions).toList().shuffled()[0]
        )
    }
    fun getList(ctxt:Context){
        val charactLab = CharactLab(ctxt)
        mCharactList = arrayListOf<CharactItem>()
        for(i in mNames.indices)
            mCharactList.add(CharactItem(name = context.getString(mNames[i]),description = mDescriptions[i].toString()))
    }
}