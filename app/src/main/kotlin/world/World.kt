package fr.vcernuta.app.world

import com.raylib.Raylib
import fr.vcernuta.app.entities.Tile
import fr.vcernuta.app.utils.Textures

class World {
	
	var tiles: List<Tile>
		private set
	
	constructor(textures: Textures, directory: String) {
		val world = WorldLoader.load(directory)
		this.tiles = world.map { Tile.fromRawTile(it, textures) }
	}
	
	fun findSolidTilesMatchingDirection(direction: Raylib.Vector2): List<Tile> {
		val tiles = mutableListOf<Tile>()
		
		for (tile in this.tiles) {
			val rect = Raylib.Rectangle().x(direction.x()).y(direction.y()).width(32F).height(32F)
			if (tile.solid && Raylib.CheckCollisionRecs(tile.asRect(), rect)) {
				tiles.add(tile)
			}
		}
		
		return tiles
	}
	
}
