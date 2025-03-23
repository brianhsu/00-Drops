package coding.games
package screen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.{ApplicationListener, Gdx}

class MainGame extends ApplicationListener {

  private val PIXEL_PER_SECOND = 200

  private lazy val spriteBatch = new SpriteBatch()
  private lazy val bucketTexture: Texture = new Texture(Gdx.files.internal("bucket.png"))

  private var positionX: Float = 0.0f
  private var positionY: Float = 0.0f

  override def create(): Unit = {}

  override def resize(width: Int, height: Int): Unit = {}

  override def render(): Unit = {

    val (offsetX, offsetY) = getOffsetFromUserInput()

    updateGameWorld(offsetX, offsetY)

    drawGameWorld()
  }

  private def updateGameWorld(offsetX: Float, offsetY: Float): Unit = {
    this.positionX = Math.clamp(positionX + offsetX, 0, 1080 - bucketTexture.getWidth)
    this.positionY = Math.clamp(positionY + offsetY, 0, 720 - bucketTexture.getHeight)
  }

  private def getOffsetFromUserInput(): (Float, Float) = {

    println("getOffsetFromUserInput:" + System.currentTimeMillis())
    var offsetX: Float = 0
    var offsetY: Float = 0

    val velocity = PIXEL_PER_SECOND * Gdx.graphics.getDeltaTime

    if (Gdx.input.isKeyPressed(Keys.D)) {
      offsetX = velocity
    }

    if (Gdx.input.isKeyPressed(Keys.A)) {
      offsetX = - velocity
    }

    if (Gdx.input.isKeyPressed(Keys.W)) {
      offsetY = velocity
    }

    if (Gdx.input.isKeyPressed(Keys.S)) {
      offsetY = - velocity
    }

    (offsetX, offsetY)
  }

  private def drawGameWorld(): Unit = {
    ScreenUtils.clear(Color.DARK_GRAY)

    spriteBatch.begin()
    spriteBatch.draw(bucketTexture, positionX, positionY)
    spriteBatch.end()
  }

  override def pause(): Unit = {}

  override def resume(): Unit = {}

  override def dispose(): Unit = {
    bucketTexture.dispose()
    spriteBatch.dispose()
  }
}
