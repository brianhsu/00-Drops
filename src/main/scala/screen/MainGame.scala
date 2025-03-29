package coding.games
package screen

import core.DropsController
import sprite.Bucket

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.{ApplicationListener, Gdx}

class MainGame extends ApplicationListener {

  private lazy val spriteBatch = new SpriteBatch()

  private val bucket = new Bucket
  private val dropsController = new DropsController

  override def create(): Unit = {
    Gdx.input.setInputProcessor(bucket)
  }

  override def resize(width: Int, height: Int): Unit = {}

  override def render(): Unit = {
    updateGameWorld()
    drawGameWorld()
  }

  private def updateGameWorld(): Unit = {
    dropsController.updateGameWorld()
    bucket.updateGameWorld()
  }


  private def drawGameWorld(): Unit = {
    ScreenUtils.clear(Color.DARK_GRAY)

    spriteBatch.begin()
    dropsController.draw(spriteBatch)
    bucket.draw(spriteBatch)
    spriteBatch.end()
  }

  override def pause(): Unit = {}

  override def resume(): Unit = {}

  override def dispose(): Unit = {
    Textures.dispose()
    spriteBatch.dispose()
  }
}
