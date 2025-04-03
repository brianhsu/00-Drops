package coding.games
package sprite

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.{Gdx, InputAdapter, InputProcessor}

class Bucket extends InputAdapter {

  private val CM_PER_SECOND = 20

  private lazy val sprite: Sprite = new Sprite(Textures.bucket)

  private var currentSpeedX: Float = 0
  private var currentSpeedY: Float = 0

  def draw(spriteBatch: SpriteBatch): Unit = {
    this.sprite.draw(spriteBatch)
  }

  def updateGameWorld(): Unit = {

    val offsetX = currentSpeedX * Gdx.graphics.getDeltaTime
    val offsetY = currentSpeedY * Gdx.graphics.getDeltaTime

    this.sprite.setSize(10, 10)
    this.sprite.setX(Math.clamp(this.sprite.getX + offsetX, 0, GameWorld.WIDTH - this.sprite.getWidth))
    this.sprite.setY(Math.clamp(this.sprite.getY + offsetY, 0, GameWorld.HEIGHT - this.sprite.getHeight))
  }

  override def keyDown(keycode: Int): Boolean = {

    currentSpeedX = keycode match {
      case Keys.D => currentSpeedX + CM_PER_SECOND
      case Keys.A => currentSpeedX - CM_PER_SECOND
      case _      => currentSpeedX
    }

    currentSpeedY = keycode match {
      case Keys.W => currentSpeedY + CM_PER_SECOND
      case Keys.S => currentSpeedY - CM_PER_SECOND
      case _      => currentSpeedY
    }

    true
  }

  override def keyUp(keycode: Int): Boolean = {
    currentSpeedX = keycode match {
      case Keys.D => currentSpeedX - CM_PER_SECOND
      case Keys.A => currentSpeedX + CM_PER_SECOND
      case _      => currentSpeedX
    }

    currentSpeedY = keycode match {
      case Keys.W => currentSpeedY - CM_PER_SECOND
      case Keys.S => currentSpeedY + CM_PER_SECOND
      case _      => currentSpeedY
    }

    true
  }

  override def mouseMoved(screenX: Int, screenY: Int): Boolean = {
    println(s"ScreenX, ScreenY: $screenX, $screenY")
    val coordinate = GameWorld.FIT_VIEWPORT.unproject(new Vector2(screenX, screenY))
    this.sprite.setCenterX(coordinate.x)
    this.sprite.setCenterY(coordinate.y)
    false
  }
}
