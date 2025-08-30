package fr.vcernuta.app.world

import kotlin.io.path.Path

data class RawTile(
	val x: Int,
	val y: Int,
	val layer: Int,
	val solid: Int,
	val texture: String,
) {
	companion object {
		fun fromString(line: String, baseTile: RawTile?): RawTile {
			var baseX = 0
			var baseY = 0
			var baseLayer = 0
			
			if (baseTile != null) {
				baseX = baseTile.x
				baseY = baseTile.y
				baseLayer = baseTile.layer
			}
			
			val parts = line.split(" ").map { it.trim() }
			val x = parts[0].toInt()
			val y = parts[1].toInt()
			val solid = parts[3].toInt()
			val layer = parts[4].toInt()
			
			return RawTile(
				x = baseX + x,
				y = baseY + y,
				layer = baseLayer + layer,
				solid = solid,
				texture = parts[2],
			)
		}
	}
}

object WorldLoader {
	
	fun load(directory: String): List<RawTile> {
		return loadFromPath(null, directory, "level.txt")
	}
	
	private fun loadFromPath(baseTile: RawTile?, directory: String, vararg subpath: String): List<RawTile> {
		val relativePath = Path(directory, *subpath)
		val file = relativePath.toFile().readText().trim().lines()
		
		return parseLines(baseTile, directory, file)
	}
	
	private fun parseLines(baseTile: RawTile?, directory: String, lines: List<String>): List<RawTile> {
		val tiles = mutableListOf<RawTile>()
		
		for (line in lines) {
			// Skip empty lines
			if (line.isEmpty()) {
				continue
			}
			
			// Skip comments
			if (line.startsWith("#")) {
				continue
			}
			
			val tile = RawTile.fromString(line, baseTile)
			if (tile.texture.startsWith("model#")) {
				val name = tile.texture.substringAfter("model#")
				val children = loadFromPath(tile, directory, "models", "$name.txt")
				tiles.addAll(children)
			} else {
				tiles.add(tile)
			}
		}
		
		return tiles
	}
	
}
