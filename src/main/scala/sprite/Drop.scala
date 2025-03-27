package coding.games
package sprite

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}

import scala.util.Random

class Drop {

  private val fallingSpeed = Random.between(20, 200)
  private lazy val sprite: Sprite = createSpriteWithRandomX()

  def updateGameWorld(): Unit = {
    this.sprite.translateY(-fallingSpeed * Gdx.graphics.getDeltaTime)
  }

  def draw(spriteBatch: SpriteBatch): Unit = {
    this.sprite.draw(spriteBatch)
  }

  def isFalloutOfScreen: Boolean = this.sprite.getY < -this.sprite.getHeight

  private def createSpriteWithRandomX(): Sprite = {
    val sprite = new Sprite(Textures.drop)

    sprite.setX(Random.between(0, 1080 - Textures.drop.getWidth))
    sprite.setY(720)

    sprite
  }


}
