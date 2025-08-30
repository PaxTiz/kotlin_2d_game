package fr.vcernuta.app.renderer

import fr.vcernuta.app.entities.Entity
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.world.World

class Renderer (
	private var currentId: Int = 0,
	private var objects: MutableMap<Int, Entity> = mutableMapOf()
) {
	
	fun addObject(obj: Entity): Int {
		val id = currentId
		objects[id] = obj
		currentId += 1
		
		return id
	}
	
	fun syncWithWorld(world: World) {
		for (tile in world.tiles) {
			tile.setId(addObject(tile))
		}
	}
	
	fun render(game: Game) {
		for (obj in sortObjectsForRendering()) {
			obj.render(game)
		}
	}
	
	private fun sortObjectsForRendering(): List<Entity> {
		return objects.values.sortedWith { a, b ->
			if (a.layer < b.layer) {
				-1
			} else if (a.layer > b.layer) {
				1
			} else {
				0
			}
			
		}
	}
	
}
