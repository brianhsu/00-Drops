package coding.games
package sprite

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.{Gdx, InputAdapter, InputProcessor}

class Bucket extends InputAdapter {

  private val PIXEL_PER_SECOND = 200

  private lazy val sprite: Sprite = new Sprite(Textures.bucket)

  private var currentSpeedX: Float = 0
  private var currentSpeedY: Float = 0

  def draw(spriteBatch: SpriteBatch): Unit = {
    this.sprite.draw(spriteBatch)
  }

  def updateGameWorld(): Unit = {

    val offsetX = currentSpeedX * Gdx.graphics.getDeltaTime
    val offsetY = currentSpeedY * Gdx.graphics.getDeltaTime

    this.sprite.setX(Math.clamp(this.sprite.getX + offsetX, 0, GameWorld.WIDTH - Textures.bucket.getWidth))
    this.sprite.setY(Math.clamp(this.sprite.getY + offsetY, 0, GameWorld.HEIGHT - Textures.bucket.getHeight))
  }

  override def keyDown(keycode: Int): Boolean = {

    currentSpeedX = keycode match {
      case Keys.D => currentSpeedX + PIXEL_PER_SECOND
      case Keys.A => currentSpeedX - PIXEL_PER_SECOND
      case _      => currentSpeedX
    }

    currentSpeedY = keycode match {
      case Keys.W => currentSpeedY + PIXEL_PER_SECOND
      case Keys.S => currentSpeedY - PIXEL_PER_SECOND
      case _      => currentSpeedY
    }

    true
  }

  override def keyUp(keycode: Int): Boolean = {
    currentSpeedX = keycode match {
      case Keys.D => currentSpeedX - PIXEL_PER_SECOND
      case Keys.A => currentSpeedX + PIXEL_PER_SECOND
      case _      => currentSpeedX
    }

    currentSpeedY = keycode match {
      case Keys.W => currentSpeedY - PIXEL_PER_SECOND
      case Keys.S => currentSpeedY + PIXEL_PER_SECOND
      case _      => currentSpeedY
    }

    true
  }

  override def mouseMoved(screenX: Int, screenY: Int): Boolean = {
    this.sprite.setX(screenX)
    this.sprite.setY(GameWorld.HEIGHT - screenY)
    false
  }
}
