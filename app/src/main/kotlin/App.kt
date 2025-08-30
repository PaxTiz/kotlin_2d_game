package fr.vcernuta.app

import com.raylib.Colors
import com.raylib.Raylib
import fr.vcernuta.app.game.Game
import fr.vcernuta.app.utils.Constants

fun main() {
	Raylib.InitWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, "Hello From Raylib !")
	
	Raylib.SetConfigFlags(Raylib.FLAG_VSYNC_HINT)
	Raylib.SetTargetFPS(60)
	
	val game = Game(true)
	
	while (!Raylib.WindowShouldClose()) {
		Raylib.BeginDrawing()
		Raylib.BeginMode2D(game.camera.camera)
		
		Raylib.ClearBackground(Colors.BLACK)
		
		game.handleKeyboardEvents()
		game.render()
		
		Raylib.EndMode2D()
		Raylib.EndDrawing()
	}
	
	game.unloadTextures()
	Raylib.CloseWindow()
}
