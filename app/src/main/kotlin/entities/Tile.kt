package fr.vcernuta.app.entities

import com.raylib.Colors
import com.raylib.Raylib
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants
import fr.vcernuta.app.utils.Textures
import fr.vcernuta.app.world.RawTile

class Tile : Entity {
	
	var solid: Boolean
		private set
	
	private constructor(
		texture: Raylib.Texture,
		size: Raylib.Vector2,
		position: Raylib.Vector2,
		spritesheetPosition: Raylib.Vector2,
		collisionRect: Raylib.Rectangle,
		layer: Int,
		solid: Boolean,
	) : super(
		id = -1,
		texture,
		size,
		position,
		spritesheetPosition,
		collisionRect,
		layer,
	) {
		this.solid = solid
	}
	
	companion object {
		fun fromRawTile(tile: RawTile, textures: Textures): Tile {
			val spritesheetPositions = Constants.TEXTURES_SPRITESHEET_POSITIONS;
			val position = spritesheetPositions[tile.texture]!!
			
			return Tile(
				texture = textures.map,
				position = Raylib.Vector2().x((tile.x * (16 * Constants.TEXTURE_SCALING)).toFloat()).y((tile.y * (16 * Constants.TEXTURE_SCALING)).toFloat()),
				spritesheetPosition = position,
				size = Raylib.Vector2().x(16F).y(16F),
				collisionRect = Raylib.Rectangle(),
				layer = tile.layer,
				solid = tile.solid == 1,
			)
		}
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
		
		val origin = Raylib.Vector2().x(0F).y(0F)
		
		Raylib.DrawTexturePro(texture, source, destination, origin, 0F, Colors.WHITE)
		
		if (game.debug) {
			Raylib.DrawRectangleLinesEx(destination, 1F, Colors.RED)
			
			if (solid) {
				Raylib.DrawRectangleRec(destination, Raylib.ColorAlpha(Colors.RED, 0.4F))
			}
		}
	}
	
	override fun handleKeyboardEvents(game: Game, delta: Float) {
		//
	}
	
}
