package fr.vcernuta.app

import com.raylib.Raylib
import fr.vcernuta.app.entities.Player
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants

class Camera {
	
	var camera: Raylib.Camera2D
		private set
	
	constructor(player: Player) {
		val offset = Raylib.Vector2()
			.x((Constants.WINDOW_WIDTH / 2) - player.size.x() * 2)
			.y((Constants.WINDOW_HEIGHT / 2) - player.size.y() * 2)
		
		this.camera = Raylib.Camera2D()
			.zoom(1F)
			.rotation(0F)
			.target(player.position)
			.offset(offset)
	}
	
	fun syncPositionWithPlayer(player: Player) {
		camera.target(player.position)
	}
	
	fun zoom(game: Game) {
		if (game.debug) {
			val kl = game.keyboardLayout
			
			if (camera.zoom() < 5 && Raylib.IsKeyDown(kl.modifier) && Raylib.IsKeyDown(kl.plus)) {
				camera.zoom((camera.zoom() + 0.1).toFloat())
			} else if (camera.zoom() > 0.5 && Raylib.IsKeyDown(kl.modifier) && Raylib.IsKeyDown(kl.minus)) {
				camera.zoom((camera.zoom() - 0.1).toFloat())
			}
		}
	}
	
}
