package com.voronets.bunkergame.data

import java.io.Serializable

/**
 * A data class for containing character items info
 */

data class CharactItem(val name:String, var description: String, var isActivated:Boolean = false):Serializable