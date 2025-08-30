package fr.vcernuta.app.utils

import com.raylib.Raylib

data class Textures(
	val map: Raylib.Texture,
	val player: Raylib.Texture,
) {
	companion object {
		fun load(): Textures {
			return Textures(
				map = Raylib.LoadTexture("../resources/textures/tiles/spritesheets/transparent.png"),
				player = Raylib.LoadTexture("../resources/textures/characters/spr_ardley.png"),
			)
		}
	}
	
	fun unload() {
		Raylib.UnloadTexture(map)
		Raylib.UnloadTexture(player)
	}
}
