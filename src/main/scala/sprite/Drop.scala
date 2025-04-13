package coding.games
package sprite

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch}
import com.badlogic.gdx.math.Rectangle

import scala.util.Random

class Drop {

  private val fallingSpeed = Random.between(2, 20)
  private lazy val sprite: Sprite = createSpriteWithRandomX()

  def collisionArea: Rectangle = this.sprite.getBoundingRectangle

  def updateGameWorld(): Unit = {
    this.sprite.translateY(-fallingSpeed * Gdx.graphics.getDeltaTime)
  }

  def draw(spriteBatch: SpriteBatch): Unit = {
    this.sprite.draw(spriteBatch)
  }

  def isFalloutOfScreen: Boolean = this.sprite.getY < -this.sprite.getHeight

  private def createSpriteWithRandomX(): Sprite = {
    val sprite = new Sprite(Textures.drop)

    sprite.setSize(10, 10)
    sprite.setX(Random.between(0, GameWorld.WIDTH - sprite.getWidth))
    sprite.setY(GameWorld.HEIGHT)

    sprite
  }


}
