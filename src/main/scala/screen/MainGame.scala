package coding.games
package screen

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.{ApplicationListener, Gdx}

class MainGame extends ApplicationListener {

  private val PIXEL_PER_SECOND = 200

  private lazy val spriteBatch = new SpriteBatch()
  private lazy val bucketTexture: Texture = new Texture(Gdx.files.internal("bucket.png"))

  private var positionX: Float = 0.0f

  override def create(): Unit = {}

  override def resize(width: Int, height: Int): Unit = {}

  override def render(): Unit = {

    ScreenUtils.clear(Color.DARK_GRAY)

    spriteBatch.begin()
    spriteBatch.draw(bucketTexture, positionX, 0)
    spriteBatch.end()

    positionX += PIXEL_PER_SECOND * Gdx.graphics.getDeltaTime
  }

  override def pause(): Unit = {}

  override def resume(): Unit = {}

  override def dispose(): Unit = {
    bucketTexture.dispose()
    spriteBatch.dispose()
  }
}
