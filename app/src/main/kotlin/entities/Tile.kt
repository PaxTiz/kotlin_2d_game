package fr.vcernuta.app.entities

import com.raylib.Colors
import com.raylib.Raylib
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants
import fr.vcernuta.app.utils.Textures
import fr.vcernuta.app.world.RawTile
import fr.vcernuta.utils.textures.getTexturePosition
import fr.vcernuta.utils.wrappers.Rectangle
import fr.vcernuta.utils.wrappers.Vector2

class Tile : Entity {
	
	var solid: Boolean
		private set
	
	private constructor(
		texture: Raylib.Texture,
		size: Vector2,
		position: Vector2,
		spritesheetPosition: Vector2,
		collisionRect: Rectangle,
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
			val position = getTexturePosition(tile.texture)
			
			return Tile(
				texture = textures.map,
				position = Vector2(
					x = (tile.x * (16 * Constants.TEXTURE_SCALING).toDouble()),
					y = (tile.y * (16 * Constants.TEXTURE_SCALING).toDouble()),
				),
				spritesheetPosition = position,
				size = Vector2(16.toDouble(), 16.toDouble()),
				collisionRect = Rectangle.zero(),
				layer = tile.layer,
				solid = tile.solid == 1,
			)
		}
	}
	
	override fun render(game: Game) {
		val source = Rectangle(
			x = spritesheetPosition.x,
			y = spritesheetPosition.y,
			width = size.x,
			height = size.y,
		)
		
		val destination = Rectangle(
			x = position.x,
			y = position.y,
			width = size.x * Constants.TEXTURE_SCALING,
			height = size.y * Constants.TEXTURE_SCALING,
		)
		
		val origin = Vector2.zero()
		
		Raylib.DrawTexturePro(texture, source.rl(), destination.rl(), origin.rl(), 0F, Colors.WHITE)
		
		if (game.debug) {
			Raylib.DrawRectangleLinesEx(destination.rl(), 1F, Colors.RED)
			
			if (solid) {
				Raylib.DrawRectangleRec(destination.rl(), Raylib.ColorAlpha(Colors.RED, 0.4F))
			}
		}
	}
	
	override fun handleKeyboardEvents(game: Game, delta: Float) {
		//
	}
	
}
