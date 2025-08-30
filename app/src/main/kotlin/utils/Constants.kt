package fr.vcernuta.app.utils

import com.raylib.Raylib

fun Int.spritesheetPosition(): Float {
	return ((this - 1) * 16 + (this - 1)).toFloat()
}

object Constants {
	
	const val WINDOW_WIDTH = 800
	const val WINDOW_HEIGHT = 640
	
	const val TEXTURE_SCALING = 2
	const val TILE_WIDTH = 32
	const val TILE_HEIGHT = 32
	
	val TEXTURES_SPRITESHEET_POSITIONS = mapOf(
		"__empty__" to Raylib.Vector2().x(1.spritesheetPosition()).y(1.spritesheetPosition()),
		
		// Water
		"pool_top_left_corner" to Raylib.Vector2().x(3.spritesheetPosition()).y(0F),
		"pool_top_center" to Raylib.Vector2().x(4.spritesheetPosition()).y(0F),
		"pool_top_right_corner" to Raylib.Vector2().x(5.spritesheetPosition()).y(0F),
		"pool_side_left" to Raylib.Vector2().x(3.spritesheetPosition()).y(2.spritesheetPosition()),
		"pool_full_water" to Raylib.Vector2().x(4.spritesheetPosition()).y(2.spritesheetPosition()),
		"pool_side_right" to Raylib.Vector2().x(5.spritesheetPosition()).y(2.spritesheetPosition()),
		"pool_bottom_left_corner" to Raylib.Vector2().x(3.spritesheetPosition()).y(3.spritesheetPosition()),
		"pool_bottom_center" to Raylib.Vector2().x(4.spritesheetPosition()).y(3.spritesheetPosition()),
		"pool_bottom_right_corner" to Raylib.Vector2().x(5.spritesheetPosition()).y(3.spritesheetPosition()),
		
		// Grass
		"grass_1" to Raylib.Vector2().x(6.spritesheetPosition()).y(1.spritesheetPosition()),
		"grass_2" to Raylib.Vector2().x(6.spritesheetPosition()).y(1.spritesheetPosition()),
		
		// Dirt
		"dirt_1" to Raylib.Vector2().x(7.spritesheetPosition()).y(1.spritesheetPosition()),
		"dirt_2" to Raylib.Vector2().x(7.spritesheetPosition()).y(1.spritesheetPosition()),
		"dirth_path_top_left_corner" to Raylib.Vector2().x(8.spritesheetPosition()).y(8.spritesheetPosition()),
		"dirth_path_top_right_corner" to Raylib.Vector2().x(9.spritesheetPosition()).y(8.spritesheetPosition()),
		"dirth_path_bottom_left_corner" to Raylib.Vector2().x(8.spritesheetPosition()).y(9.spritesheetPosition()),
		"dirth_path_bottom_right_corner" to Raylib.Vector2().x(9.spritesheetPosition()).y(9.spritesheetPosition()),
		"dirth_path_top_end" to Raylib.Vector2().x(7.spritesheetPosition()).y(12.spritesheetPosition()),
		"dirth_path_bottom_end" to Raylib.Vector2().x(6.spritesheetPosition()).y(12.spritesheetPosition()),
		"dirth_path_left_end" to Raylib.Vector2().x(7.spritesheetPosition()).y(13.spritesheetPosition()),
		"dirth_path_right_end" to Raylib.Vector2().x(6.spritesheetPosition()).y(13.spritesheetPosition()),
		"dirth_path_vertical" to Raylib.Vector2().x(10.spritesheetPosition()).y(8.spritesheetPosition()),
		"dirth_path_horizontal" to Raylib.Vector2().x(10.spritesheetPosition()).y(9.spritesheetPosition()),
		
		// Green tree
		"tree_green_pic_top" to Raylib.Vector2().x(17.spritesheetPosition()).y(11.spritesheetPosition()),
		"tree_green_pic_bottom" to Raylib.Vector2().x(17.spritesheetPosition()).y(12.spritesheetPosition()),
		
		// Home walls
		"home_wall_white_bottom_left_corner" to Raylib.Vector2().x(15.spritesheetPosition())
			.y(16.spritesheetPosition()),
		"home_wall_white_bottom_right_corner" to Raylib.Vector2().x(17.spritesheetPosition())
			.y(16.spritesheetPosition()),
		"home_wall_white_full" to Raylib.Vector2().x(19.spritesheetPosition()).y(16.spritesheetPosition()),
		
		// Home roofs
		"home_roof_wood_top_left_corner" to Raylib.Vector2().x(21.spritesheetPosition()).y(22.spritesheetPosition()),
		"home_roof_wood_top_right_corner" to Raylib.Vector2().x(22.spritesheetPosition()).y(22.spritesheetPosition()),
		"home_roof_wood_left" to Raylib.Vector2().x(21.spritesheetPosition()).y(23.spritesheetPosition()),
		"home_roof_wood_right" to Raylib.Vector2().x(22.spritesheetPosition()).y(23.spritesheetPosition()),
		"home_roof_wood_bottom_left_corner" to Raylib.Vector2().x(21.spritesheetPosition()).y(24.spritesheetPosition()),
		"home_roof_wood_bottom_right_corner" to Raylib.Vector2().x(22.spritesheetPosition())
			.y(24.spritesheetPosition()),
		
		// Doors
		"door_rounded_black_background_left" to Raylib.Vector2().x(29.spritesheetPosition()).y(9.spritesheetPosition()),
		"door_rounded_black_background_right" to Raylib.Vector2().x(30.spritesheetPosition())
			.y(9.spritesheetPosition()),
	)
	
}
