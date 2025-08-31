package fr.vcernuta.app.entities.animation

import com.raylib.Raylib
import fr.vcernuta.app.entities.Entity
import fr.vcernuta.app.game.Game
import fr.vcernuta.utils.wrappers.Rectangle
import fr.vcernuta.utils.wrappers.Vector2

abstract class AnimableEntity<Animation : EntityAnimation<*, *>>(
	id: Int,
	texture: Raylib.Texture,
	size: Vector2,
	position: Vector2,
	spritesheetPosition: Vector2,
	collisionRect: Rectangle,
	layer: Int,
	protected var animation: Animation
) : Entity(id, texture, size, position, spritesheetPosition, collisionRect, layer) {
	
	abstract override fun render(game: Game)
	abstract override fun handleKeyboardEvents(game: Game, delta: Float)
	
}
