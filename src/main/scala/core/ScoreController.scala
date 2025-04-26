package coding.games
package core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}

class ScoreController {
  private var score: Int = 0
  private var life: Int = 3

  private lazy val bitmapFont = generateFont(30)

  def scored(): Unit = {
    score += 200
  }

  def lostLife(): Unit = {
    life -= 1
  }
  
  def isDead: Boolean = life <= 0

  def draw(spriteBatch: SpriteBatch): Unit = {
    spriteBatch.setProjectionMatrix(GameWorld.UI_VIEWPORT.getCamera.combined)
    bitmapFont.draw(spriteBatch, s"分數： $score", 10, GameWorld.UI_VIEWPORT.getWorldHeight - 10)
    bitmapFont.draw(spriteBatch, s"生命值： $life", 10, GameWorld.UI_VIEWPORT.getWorldHeight - 50)

  }

  def dispose(): Unit = {
    bitmapFont.dispose()
  }

  private def generateFont(size: Int): BitmapFont = {
    val generator = new FreeTypeFontGenerator(Gdx.files.internal("NotoSansTC-Medium.ttf"))
    val parameter = new FreeTypeFontParameter

    parameter.size = size
    parameter.borderColor = Color.BLACK
    parameter.borderWidth = 2
    parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS + "分數生命值："

    generator.generateFont(parameter)
  }


}
