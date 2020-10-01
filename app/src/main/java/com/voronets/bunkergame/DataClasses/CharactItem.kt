package com.voronets.bunkergame.DataClasses

/**
 * A data class for containing character items info
 */

data class CharactItem(val name:String, var description: String, val isActivated:Boolean = false)