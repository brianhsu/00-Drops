package coding.games
package screen

import coding.games.sprite.Bucket
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.{ApplicationListener, Gdx}

class MainGame extends ApplicationListener {


  private lazy val spriteBatch = new SpriteBatch()

  private val bucket = new Bucket

  override def create(): Unit = {
    Gdx.input.setInputProcessor(bucket)
  }

  override def resize(width: Int, height: Int): Unit = {}

  override def render(): Unit = {
    bucket.updateGameWorld()
    drawGameWorld()
  }


  private def drawGameWorld(): Unit = {
    ScreenUtils.clear(Color.DARK_GRAY)

    spriteBatch.begin()
    spriteBatch.draw(bucket.texture, bucket.positionX, bucket.positionY)
    spriteBatch.end()
  }

  override def pause(): Unit = {}

  override def resume(): Unit = {}

  override def dispose(): Unit = {
    bucket.texture.dispose()
    spriteBatch.dispose()
  }
}
