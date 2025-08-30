package fr.vcernuta.app.entities

import com.raylib.Colors
import com.raylib.Raylib
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants
import fr.vcernuta.app.utils.Textures

class Player : Entity {
	
	constructor(textures: Textures) : super(
		id = -1,
		texture = textures.player,
		size = Raylib.Vector2().x(16F).y(32F),
		position = Raylib.Vector2().x((Constants.WINDOW_WIDTH / 2 - 16).toFloat())
			.y((Constants.WINDOW_HEIGHT / 4 - 32 * 2).toFloat()),
		spritesheetPosition = Raylib.Vector2().x(0F).y(0F),
		collisionRect = Raylib.Rectangle().x((Constants.WINDOW_WIDTH / 2 - 16).toFloat())
			.y((Constants.WINDOW_HEIGHT / 4 - 32 * 2).toFloat()).width(32F).height(32F),
		layer = 10,
	) {
	}
	
	override fun render(game: Game) {
		val source = Raylib.Rectangle()
			.x(spritesheetPosition.x())
			.y(spritesheetPosition.y())
			.width(size.x())
			.height(size.y())
		
		val destination = Raylib.Rectangle()
			.x(position.x())
			.y(position.y())
			.width(size.x() * Constants.TEXTURE_SCALING)
			.height(size.y() * Constants.TEXTURE_SCALING)
		
		val origin = Raylib.Vector2().x(0F).y(0F);
		
		Raylib.DrawTexturePro(texture, source, destination, origin, 0F, Colors.WHITE)
	}
	
	override fun handleKeyboardEvents(game: Game, delta: Float) {
		//
	}
	
}
