package fr.vcernuta.app.entities.player

import com.raylib.Colors
import com.raylib.Raylib
import fr.vcernuta.app.entities.animation.AnimableEntity
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants
import fr.vcernuta.app.utils.Textures
import fr.vcernuta.utils.wrappers.Rectangle
import fr.vcernuta.utils.wrappers.Vector2

const val PLAYER_SPEED = 150

class Player : AnimableEntity<PlayerAnimation> {
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
		animation = PlayerAnimation()
	) {
	}
	
	override fun render(game: Game) {
		animation.loop()
		val spritePos = animation.spritePosition()
		
		val source = Rectangle(
			x = spritePos.x,
			y = spritePos.y,
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
		animation.updateTime(delta)
		
		val displacement = PLAYER_SPEED * delta
		
		val movement = Vector2.zero()
		onMove(game.keyboardLayout.playerLeft) {
			movement.x -= displacement
			animation.sprite = PlayerSprite.Left
		}
		onMove(game.keyboardLayout.playerRight) {
			movement.x += displacement
			animation.sprite = PlayerSprite.Right
		}
		onMove(game.keyboardLayout.playerTop) {
			movement.y -= displacement
			animation.sprite = PlayerSprite.Top
		}
		onMove(game.keyboardLayout.playerBottom) {
			movement.y += displacement
			animation.sprite = PlayerSprite.Bottom
		}
		
		if (movement.isZero()) {
			animation.state = PlayerState.Idle
		} else {
			animation.state = PlayerState.Moving
			
			if (checkCollisions(game, Vector2(position.x + movement.x, position.y + 32))) {
				position.x += movement.x
				collisionRect.x += movement.x
			}
			if (checkCollisions(game, Vector2(position.x, position.y + movement.y + 32))) {
				position.y += movement.y
				collisionRect.y += movement.y + size.y
			}
		}
	}
	
	private fun checkCollisions(game: Game, position: Vector2): Boolean {
		return game.world.findSolidTilesMatchingDirection(position).isEmpty()
	}
	
	private fun onMove(key: Int, callback: () -> Unit) {
		if (Raylib.IsKeyDown(key)) {
			callback()
		}
	}
}
