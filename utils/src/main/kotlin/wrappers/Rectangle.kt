package fr.vcernuta.utils.wrappers

import com.raylib.Raylib

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
