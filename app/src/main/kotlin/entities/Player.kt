package fr.vcernuta.app.entities

import com.raylib.Colors
import com.raylib.Raylib
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants
import fr.vcernuta.app.utils.Rectangle
import fr.vcernuta.app.utils.Textures
import fr.vcernuta.app.utils.Vector2

const val PLAYER_SPEED = 150

class Player : Entity {
	
	constructor(textures: Textures) : super(
		id = -1,
		texture = textures.player,
		size = Vector2(16.toDouble(), 32.toDouble()),
		position = Vector2(
			x = (Constants.WINDOW_WIDTH / 2 - 16).toDouble(),
			y = ((Constants.WINDOW_HEIGHT / 4) - (32 * 2)).toDouble()
		),
		spritesheetPosition = Vector2.zero(),
		collisionRect = Rectangle(
			x = (Constants.WINDOW_WIDTH / 2 - 16).toDouble(),
			y = (Constants.WINDOW_HEIGHT / 4 - 32 * 2).toDouble(),
			width = 32.toDouble(),
			height = 32.toDouble(),
		),
		layer = 10,
	) {
	}
	
	override fun render(game: Game) {
		val source = Rectangle(
			x = spritesheetPosition.x,
			y = spritesheetPosition.y,
			width = size.x,
			height = size.y
		)
		
		val destination = Rectangle(
			x = position.x,
			y = position.y,
			width = size.x * Constants.TEXTURE_SCALING,
			height = size.y * Constants.TEXTURE_SCALING,
		)
		
		val origin = Vector2.zero()
		
		Raylib.DrawTexturePro(texture, source.rl(), destination.rl(), origin.rl(), 0F, Colors.WHITE)
	}
	
	override fun handleKeyboardEvents(game: Game, delta: Float) {
		val displacement = PLAYER_SPEED * delta
		
		val movement = position.copy()
		movement.x -= handleMove(game.keyboardLayout.playerLeft, displacement)
		movement.x += handleMove(game.keyboardLayout.playerRight, displacement)
		movement.y -= handleMove(game.keyboardLayout.playerTop, displacement)
		movement.y += handleMove(game.keyboardLayout.playerBottom, displacement)
		
		if (checkCollisions(game, Vector2(movement.x, position.y + 32))) {
			position.x = movement.x
			collisionRect.x = movement.x
		}
		if (checkCollisions(game, Vector2(position.x, movement.y + 32))) {
			position.y = movement.y
			collisionRect.y = movement.y + size.y
		}
	}
	
	private fun checkCollisions(game: Game, position: Vector2): Boolean {
		return game.world.findSolidTilesMatchingDirection(position).isEmpty()
	}
	
	private fun handleMove(key: Int, displacement: Float): Float {
		if (Raylib.IsKeyDown(key)) {
			return displacement
		}
		
		return 0F
	}
	
}
