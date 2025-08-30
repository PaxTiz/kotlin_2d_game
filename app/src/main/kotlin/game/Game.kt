package fr.vcernuta.app.game

import com.raylib.Raylib
import fr.vcernuta.app.Camera
import fr.vcernuta.app.entities.Player
import fr.vcernuta.app.renderer.Renderer
import fr.vcernuta.app.utils.KeyboardLayout
import fr.vcernuta.app.utils.Textures
import fr.vcernuta.app.world.World

class Game {
	
	var debug: Boolean
		private set
	
	var textures: Textures
		private set
	
	var keyboardLayout: KeyboardLayout
		private set
	
	var world: World
		private set
	
	var renderer: Renderer
		private set
	
	var player: Player
		private set
	
	var camera: Camera
		private set
	
	constructor(debug: Boolean) {
		this.debug = debug
		this.textures = Textures.load()
		this.keyboardLayout = KeyboardLayout.azerty()
		this.world = World(textures, "../resources/levels/home")
		this.player = Player(textures)
		this.camera = Camera(player)
		
		this.renderer = Renderer()
		this.player.setId(renderer.addObject(player))
		this.renderer.syncWithWorld(world)
	}
	
	fun handleKeyboardEvents() {
		val delta = Raylib.GetFrameTime()
		
		player.handleKeyboardEvents(this, delta)
		camera.syncPositionWithPlayer(player)
		camera.zoom(this)
		
		handleReloadKeypress()
	}
	
	fun render() {
		renderer.render(this)
	}
	
	fun unloadTextures() {
		textures.unload()
	}
	
	private fun handleReloadKeypress() {
		if (Raylib.IsKeyPressed(keyboardLayout.softReload)) {
			textures = Textures.load()
		}
	}
}
