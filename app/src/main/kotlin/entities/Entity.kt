package fr.vcernuta.app.entities

import com.raylib.Raylib
import fr.vcernuta.app.game.Game

abstract class Entity {
	
	var id: Int
		private set
	
	var texture: Raylib.Texture
		private set
	
	var size: Raylib.Vector2
		private set
	
	var position: Raylib.Vector2
		private set
	
	var spritesheetPosition: Raylib.Vector2
		private set
	
	var collisionRect: Raylib.Rectangle
		private set
	
	var layer: Int
		private set
	
	constructor(
		id: Int,
		texture: Raylib.Texture,
		size: Raylib.Vector2,
		position: Raylib.Vector2,
		spritesheetPosition: Raylib.Vector2,
		collisionRect: Raylib.Rectangle,
		layer: Int,
	) {
		this.id = id
		this.texture = texture
		this.size = size
		this.position = position
		this.spritesheetPosition = spritesheetPosition
		this.collisionRect = collisionRect
		this.layer = layer
	}
	
	fun setId(id: Int) {
		this.id = id
	}
	
	abstract fun render(game: Game)
	abstract fun handleKeyboardEvents(game: Game, delta: Float)
	
}
