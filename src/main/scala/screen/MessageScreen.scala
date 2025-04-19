package coding.games
package screen

import coding.games.core.GameController
import com.badlogic.gdx.Input.{Buttons, Keys}
import com.badlogic.gdx.{Gdx, Screen}
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

class MessageScreen(gameController: GameController, imageFile: String) extends Screen {

  private lazy val image: Texture = new Texture(Gdx.files.internal(imageFile))
  private lazy val spriteBatch = new SpriteBatch

  override def show(): Unit = {}

  override def hide(): Unit = {}

  override def render(delta: Float): Unit = {
    ScreenUtils.clear(Color.DARK_GRAY)

    if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)
      || Gdx.input.isButtonJustPressed(Buttons.LEFT)) {

      gameController.startGame()
    }

    spriteBatch.begin()
    spriteBatch.setProjectionMatrix(GameWorld.UI_VIEWPORT.getCamera.combined)
    spriteBatch.draw(image, 0, 0)
    spriteBatch.end()
  }

  override def resize(width: Int, height: Int): Unit = {
    GameWorld.UI_VIEWPORT.update(width, height, true)
  }

  override def pause(): Unit = {}

  override def resume(): Unit = {}

  override def dispose(): Unit = {
    spriteBatch.dispose()
    image.dispose()
  }

}
