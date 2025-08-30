package fr.vcernuta.app.utils

import com.raylib.Raylib

data class Vector2(var x: Double, var y: Double) {
	companion object {
		fun zero(): Vector2 {
			return Vector2(0.toDouble(), 0.toDouble())
		}
	}
	
	fun rl(): Raylib.Vector2 = Raylib.Vector2()
		.x(x.toFloat())
		.y(y.toFloat())
}

data class Rectangle(var x: Double, var y: Double, var width: Double, var height: Double) {
	companion object {
		fun zero(): Rectangle {
			return Rectangle(0.toDouble(), 0.toDouble(), 0.toDouble(), 0.toDouble())
		}
	}
	
	fun rl(): Raylib.Rectangle = Raylib.Rectangle()
		.x(x.toFloat())
		.y(y.toFloat())
		.width(width.toFloat())
		.height(height.toFloat())
}
