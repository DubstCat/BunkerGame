package com.voronets.bunkergame.DataClasses

import java.io.Serializable

/**
 * A data class for containing character items info
 */

data class CharactItem(val name:String, var description: String, val isActivated:Boolean = false):Serializable