package fr.vcernuta.app

import com.raylib.Colors
import com.raylib.Raylib;

fun main() {
	Raylib.InitWindow(800, 640, "Hello From Raylib !")
	
	Raylib.SetConfigFlags(Raylib.FLAG_VSYNC_HINT)
	Raylib.SetTargetFPS(60)
	
	while (!Raylib.WindowShouldClose()) {
		Raylib.BeginDrawing()
		Raylib.ClearBackground(Colors.BLACK)
		Raylib.EndDrawing()
	}
	
	Raylib.CloseWindow()
	println("Hello from Kotlin !")
}
