package coding.games
package core

import coding.games.screen.{MainGameScreen, MessageScreen}
import com.badlogic.gdx.Game

class GameController extends Game {

  private val welcomeScreen = new MessageScreen(this, "welcome.png")
  private val gameOverScreen = new MessageScreen(this, "gameover.png")

  override def create(): Unit = {
    this.setScreen(welcomeScreen)
  }

  def startGame(): Unit = {
    this.setScreen(new MainGameScreen(this))
  }

  def gameOver(): Unit = {
    this.setScreen(gameOverScreen)
  }
}
