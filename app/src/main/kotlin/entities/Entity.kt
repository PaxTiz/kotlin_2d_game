package fr.vcernuta.app.entities

import com.raylib.Raylib
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants
import fr.vcernuta.app.utils.Rectangle
import fr.vcernuta.app.utils.Vector2

abstract class Entity {
	
	var id: Int
		private set
	
	var texture: Raylib.Texture
		private set
	
	var size: Vector2
		private set
	
	var position: Vector2
		private set
	
	var spritesheetPosition: Vector2
		private set
	
	var collisionRect: Rectangle
		private set
	
	var layer: Int
		private set
	
	constructor(
		id: Int,
		texture: Raylib.Texture,
		size: Vector2,
		position: Vector2,
		spritesheetPosition: Vector2,
		collisionRect: Rectangle,
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
	
	fun asRect(): Rectangle {
		return Rectangle(
			x = position.x,
			y = position.y,
			width = size.x * Constants.TEXTURE_SCALING,
			height = size.y * Constants.TEXTURE_SCALING
		)
	}
	
	abstract fun render(game: Game)
	abstract fun handleKeyboardEvents(game: Game, delta: Float)
	
}
