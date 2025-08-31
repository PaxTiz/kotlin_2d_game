package fr.vcernuta.utils.textures

import fr.vcernuta.utils.wrappers.Vector2

private val TEXTURES_SPRITESHEET_POSITIONS = mapOf(
	"__empty__" to Vector2(
		1.spritesheetPosition(),
		1.spritesheetPosition(),
	),
	
	// Water
	"pool_top_left_corner" to Vector2(
		3.spritesheetPosition(),
		0.spritesheetPosition(),
	),
	"pool_top_center" to Vector2(
		4.spritesheetPosition(),
		0.spritesheetPosition(),
	),
	"pool_top_right_corner" to Vector2(
		5.spritesheetPosition(),
		0.spritesheetPosition(),
	),
	"pool_side_left" to Vector2(
		3.spritesheetPosition(),
		2.spritesheetPosition(),
	),
	"pool_full_water" to Vector2(
		4.spritesheetPosition(),
		2.spritesheetPosition(),
	),
	"pool_side_right" to Vector2(
		5.spritesheetPosition(),
		2.spritesheetPosition(),
	),
	"pool_bottom_left_corner" to Vector2(
		3.spritesheetPosition(),
		3.spritesheetPosition(),
	),
	"pool_bottom_center" to Vector2(
		4.spritesheetPosition(),
		3.spritesheetPosition(),
	),
	"pool_bottom_right_corner" to Vector2(
		5.spritesheetPosition(),
		3.spritesheetPosition(),
	),
	
	// Grass
	"grass_1" to Vector2(
		6.spritesheetPosition(),
		1.spritesheetPosition(),
	),
	"grass_2" to Vector2(
		6.spritesheetPosition(),
		1.spritesheetPosition(),
	),
	
	// Dirt
	"dirt_1" to Vector2(
		7.spritesheetPosition(),
		1.spritesheetPosition(),
	),
	"dirt_2" to Vector2(
		7.spritesheetPosition(),
		1.spritesheetPosition(),
	),
	"dirth_path_top_left_corner" to Vector2(
		8.spritesheetPosition(),
		8.spritesheetPosition(),
	),
	"dirth_path_top_right_corner" to Vector2(
		9.spritesheetPosition(),
		8.spritesheetPosition(),
	),
	"dirth_path_bottom_left_corner" to Vector2(
		8.spritesheetPosition(),
		9.spritesheetPosition(),
	),
	"dirth_path_bottom_right_corner" to Vector2(
		9.spritesheetPosition(),
		9.spritesheetPosition(),
	),
	"dirth_path_top_end" to Vector2(
		7.spritesheetPosition(),
		12.spritesheetPosition(),
	),
	"dirth_path_bottom_end" to Vector2(
		6.spritesheetPosition(),
		12.spritesheetPosition(),
	),
	"dirth_path_left_end" to Vector2(
		7.spritesheetPosition(),
		13.spritesheetPosition(),
	),
	"dirth_path_right_end" to Vector2(
		6.spritesheetPosition(),
		13.spritesheetPosition(),
	),
	"dirth_path_vertical" to Vector2(
		10.spritesheetPosition(),
		8.spritesheetPosition(),
	),
	"dirth_path_horizontal" to Vector2(
		10.spritesheetPosition(),
		9.spritesheetPosition(),
	),
	
	// Green tree
	"tree_green_pic_top" to Vector2(
		17.spritesheetPosition(),
		11.spritesheetPosition(),
	),
	"tree_green_pic_bottom" to Vector2(
		17.spritesheetPosition(),
		12.spritesheetPosition(),
	),
	
	// Home walls
	"home_wall_white_bottom_left_corner" to Vector2(
		15.spritesheetPosition(),
		16.spritesheetPosition(),
	),
	"home_wall_white_bottom_right_corner" to Vector2(
		17.spritesheetPosition(),
		16.spritesheetPosition(),
	),
	"home_wall_white_full" to Vector2(
		19.spritesheetPosition(),
		16.spritesheetPosition(),
	),
	
	// Home roofs
	"home_roof_wood_top_left_corner" to Vector2(
		21.spritesheetPosition(),
		22.spritesheetPosition(),
	),
	"home_roof_wood_top_right_corner" to Vector2(
		22.spritesheetPosition(),
		22.spritesheetPosition(),
	),
	"home_roof_wood_left" to Vector2(
		21.spritesheetPosition(),
		23.spritesheetPosition(),
	),
	"home_roof_wood_right" to Vector2(
		22.spritesheetPosition(),
		23.spritesheetPosition(),
	),
	"home_roof_wood_bottom_left_corner" to Vector2(
		21.spritesheetPosition(),
		24.spritesheetPosition(),
	),
	"home_roof_wood_bottom_right_corner" to Vector2(
		22.spritesheetPosition(),
		24.spritesheetPosition(),
	),
	
	// Doors
	"door_rounded_black_background_left" to Vector2(
		29.spritesheetPosition(),
		9.spritesheetPosition(),
	),
	"door_rounded_black_background_right" to Vector2(
		30.spritesheetPosition(),
		9.spritesheetPosition(),
	),
)

fun getTexturePosition(name: String): Vector2 {
	val texture = TEXTURES_SPRITESHEET_POSITIONS[name]
	if (texture == null) {
		println("[ERROR] Texture '$name' not found in supported textures")
	}
	
	return texture!!
}

fun Int.spritesheetPosition(): Double {
	if (this == 0) {
		return 0.toDouble()
	}
	
	return ((this - 1) * 16 + (this - 1)).toDouble()
}
