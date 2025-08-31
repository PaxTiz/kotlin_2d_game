package fr.vcernuta.app.world

import com.raylib.Raylib
import fr.vcernuta.app.entities.Tile
import fr.vcernuta.app.utils.Textures
import fr.vcernuta.utils.wrappers.Rectangle
import fr.vcernuta.utils.wrappers.Vector2

class World {
	
	var tiles: List<Tile>
		private set
	
	constructor(textures: Textures, directory: String) {
		val world = WorldLoader.load(directory)
		this.tiles = world.map { Tile.fromRawTile(it, textures) }
	}
	
	fun findSolidTilesMatchingDirection(direction: Vector2): List<Tile> {
		val tiles = mutableListOf<Tile>()
		
		for (tile in this.tiles) {
			val rect = Rectangle(
				x = direction.x,
				y = direction.y,
				width = 32.toDouble(),
				height = 32.toDouble()
			)
			
			if (tile.solid && Raylib.CheckCollisionRecs(tile.asRect().rl(), rect.rl())) {
				tiles.add(tile)
			}
		}
		
		return tiles
	}
	
}
