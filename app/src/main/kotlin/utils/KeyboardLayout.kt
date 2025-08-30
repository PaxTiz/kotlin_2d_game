package fr.vcernuta.app.utils

import com.raylib.Raylib

data class KeyboardLayout(
	val modifier: Int,
	val plus: Int,
	val minus: Int,
	val playerLeft: Int,
	val playerRight: Int,
	val playerTop: Int,
	val playerBottom: Int,
	val softReload: Int,
) {
	
	companion object {
		fun azerty(): KeyboardLayout {
			return KeyboardLayout(
				modifier = Raylib.KEY_LEFT_SUPER,
				plus = Raylib.KEY_SLASH,
				minus = Raylib.KEY_EQUAL,
				playerLeft = Raylib.KEY_A,
				playerRight = Raylib.KEY_D,
				playerTop = Raylib.KEY_W,
				playerBottom = Raylib.KEY_S,
				softReload = Raylib.KEY_R,
			)
		}
	}
	
}
