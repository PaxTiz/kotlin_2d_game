package fr.vcernuta.app.entities.animation

import fr.vcernuta.utils.wrappers.Vector2

interface EntityAnimationSprite<State> {
	fun states(): Map<State, List<Vector2>>
}

abstract class EntityAnimation<
		Sprite : EntityAnimationSprite<State>,
		State
		>(
	var sprite: Sprite,
	var state: State,
	private var timeSinceLastFrame: Double = 0.0,
	private val frameRate: Double = 0.25,
	private var currentSprite: Int = 0,
) {
	fun updateTime(time: Float) {
		timeSinceLastFrame += time
	}
	
	fun spritePosition(): Vector2 {
		val states = this.sprite.states()
		val sprites = states[this.state]!!
		if (sprites.size == 1) {
			return sprites[0]
		}
		
		return sprites[currentSprite]
	}
	
	fun loop() {
		if (timeSinceLastFrame > frameRate) {
			timeSinceLastFrame = 0.0
			
			val states = sprite.states()
			val actions = states[state]!!
			currentSprite = if (actions.size == 1) {
				0
			} else if (currentSprite >= actions.size - 1) {
				0
			} else {
				currentSprite + 1
			}
		}
	}
}
