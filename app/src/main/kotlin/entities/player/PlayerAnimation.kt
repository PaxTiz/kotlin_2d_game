package fr.vcernuta.app.entities.player

import fr.vcernuta.app.entities.animation.EntityAnimation
import fr.vcernuta.app.entities.animation.EntityAnimationSprite
import fr.vcernuta.utils.wrappers.Vector2

enum class PlayerState {
	Idle,
	Moving,
}

enum class PlayerSprite : EntityAnimationSprite<PlayerState> {
	Top,
	Bottom,
	Left,
	Right;
	
	override fun states(): Map<PlayerState, List<Vector2>> = when (this) {
		Left -> mapOf(
			PlayerState.Idle to listOf(Vector2(0.0, 32.0)),
			PlayerState.Moving to listOf(
				Vector2(16.0, 32.0),
				Vector2(32.0, 32.0),
				Vector2(48.0, 32.0)
			),
		)
		
		Right -> mapOf(
			PlayerState.Idle to listOf(Vector2(0.0, 64.0)),
			PlayerState.Moving to listOf(
				Vector2(16.0, 64.0),
				Vector2(32.0, 64.0),
				Vector2(48.0, 64.0)
			),
		)
		
		Top -> mapOf(
			PlayerState.Idle to listOf(Vector2(0.0, 96.0)),
			PlayerState.Moving to listOf(
				Vector2(16.0, 96.0),
				Vector2(32.0, 96.0),
				Vector2(48.0, 96.0)
			),
		)
		
		Bottom -> mapOf(
			PlayerState.Idle to listOf(Vector2.zero()),
			PlayerState.Moving to listOf(
				Vector2(16.0, 0.0),
				Vector2(32.0, 0.0),
				Vector2(48.0, 0.0)
			),
		)
	}
}

class PlayerAnimation : EntityAnimation<PlayerSprite, PlayerState>(
	sprite = PlayerSprite.Bottom,
	state = PlayerState.Idle,
) {
}
