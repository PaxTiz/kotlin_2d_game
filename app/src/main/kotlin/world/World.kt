package fr.vcernuta.app.world

import fr.vcernuta.app.entities.Tile
import fr.vcernuta.app.utils.Textures

class World {
	
	var tiles: List<Tile>
		private set
	
	constructor(textures: Textures, directory: String) {
		val world = WorldLoader.load(directory)
		this.tiles = world.map { Tile.fromRawTile(it, textures) }
	}
	
}
