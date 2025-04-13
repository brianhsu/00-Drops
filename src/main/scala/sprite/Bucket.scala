package coding.games
package sprite

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.math.{Rectangle, Vector2}
import com.badlogic.gdx.{Gdx, InputAdapter, InputProcessor}

class Bucket extends InputAdapter {

  private val CM_PER_SECOND = 40

  private lazy val sprite: Sprite = {
    val sprite = new Sprite(Textures.bucket)
    sprite.setSize(10, 10)
    sprite
  }

  private var currentSpeedX: Float = 0

  def collisionArea: Rectangle = this.sprite.getBoundingRectangle

  def draw(spriteBatch: SpriteBatch): Unit = {
    this.sprite.draw(spriteBatch)
  }

  def updateGameWorld(): Unit = {

    val offsetX = currentSpeedX * Gdx.graphics.getDeltaTime

    this.sprite.setX(Math.clamp(this.sprite.getX + offsetX, 0, GameWorld.WIDTH - this.sprite.getWidth))
  }

  override def keyDown(keycode: Int): Boolean = {

    currentSpeedX = keycode match {
      case Keys.D => currentSpeedX + CM_PER_SECOND
      case Keys.A => currentSpeedX - CM_PER_SECOND
      case _      => currentSpeedX
    }

    true
  }

  override def keyUp(keycode: Int): Boolean = {
    currentSpeedX = keycode match {
      case Keys.D => currentSpeedX - CM_PER_SECOND
      case Keys.A => currentSpeedX + CM_PER_SECOND
      case _      => currentSpeedX
    }

    true
  }

  override def mouseMoved(screenX: Int, screenY: Int): Boolean = {
    val coordinate = GameWorld.FIT_VIEWPORT.unproject(new Vector2(screenX, screenY))
    this.sprite.setCenterX(coordinate.x)
    false
  }
}
