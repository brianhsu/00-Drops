package coding.games
package sprite

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.{Gdx, InputAdapter, InputProcessor}

class Bucket extends InputAdapter {

  private val PIXEL_PER_SECOND = 200

  lazy val texture: Texture = new Texture(Gdx.files.internal("bucket.png"))
  var positionX: Float = 0.0f
  var positionY: Float = 0.0f

  var currentSpeedX: Float = 0
  var currentSpeedY: Float = 0

  def updateGameWorld(): Unit = {

    val offsetX = currentSpeedX * Gdx.graphics.getDeltaTime
    val offsetY = currentSpeedY * Gdx.graphics.getDeltaTime

    this.positionX = Math.clamp(positionX + offsetX, 0, 1080 - texture.getWidth)
    this.positionY = Math.clamp(positionY + offsetY, 0, 720 - texture.getHeight)
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
    println(s"Mouse Moved: $screenX, $screenY")
    this.positionX = screenX
    this.positionY = 720 - screenY
    false
  }
}
