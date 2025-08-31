package fr.vcernuta.utils.wrappers

import com.raylib.Raylib

data class Vector2(var x: Double, var y: Double) {
	companion object {
		fun zero(): Vector2 {
			return Vector2(0.toDouble(), 0.toDouble())
		}
	}
	
	fun isZero(): Boolean {
		return x == 0.0 && y == 0.0
	}
	
	fun rl(): Raylib.Vector2 = Raylib.Vector2()
		.x(x.toFloat())
		.y(y.toFloat())
}
