package coding.games
package screen

import core.{DropsController, GameController, ScoreController}
import sprite.Bucket

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.{ApplicationListener, Gdx, Screen}

class MainGameScreen(gameController: GameController) extends Screen {

  private lazy val spriteBatch = new SpriteBatch()

  private val bucket = new Bucket
  private val scoreController = new ScoreController
  private val dropsController = new DropsController(bucket, scoreController)

  override def show(): Unit = {
    Gdx.input.setInputProcessor(bucket)
    Sounds.backgroundMusic.setVolume(0.25f)
    Sounds.backgroundMusic.setLooping(true)
    Sounds.backgroundMusic.play()
  }

  override def hide(): Unit = {
    Sounds.backgroundMusic.stop()
    Gdx.input.setInputProcessor(null)
  }

  override def resize(width: Int, height: Int): Unit = {
    GameWorld.FIT_VIEWPORT.update(width, height, true)
    GameWorld.UI_VIEWPORT.update(width, height, true)
  }

  override def render(delta: Float): Unit = {
    updateGameWorld()
    drawGameWorld()
  }

  private def updateGameWorld(): Unit = {

    if (scoreController.isDead) {
      gameController.gameOver()
    }

    dropsController.updateGameWorld()
    bucket.updateGameWorld()
  }


  private def drawGameWorld(): Unit = {
    ScreenUtils.clear(Color.DARK_GRAY)

    spriteBatch.begin()
    spriteBatch.setProjectionMatrix(GameWorld.FIT_VIEWPORT.getCamera.combined)
    spriteBatch.draw(Textures.background, 0, 0, GameWorld.WIDTH, GameWorld.HEIGHT)
    dropsController.draw(spriteBatch)
    bucket.draw(spriteBatch)
    scoreController.draw(spriteBatch)
    spriteBatch.end()
  }

  override def pause(): Unit = {}

  override def resume(): Unit = {}

  override def dispose(): Unit = {
    Textures.dispose()
    spriteBatch.dispose()
    Sounds.dispose()
    scoreController.dispose()
  }
}
