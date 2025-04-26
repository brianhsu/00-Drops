package coding.games
package core

import coding.games.screen.{MainGameScreen, MessageScreen}
import com.badlogic.gdx.Game

class GameController extends Game {

  private val welcomeScreen = new MessageScreen("welcome.png", this)
  private val gameOverScreen = new MessageScreen("gameover.png", this)

  override def create(): Unit = {
    this.setScreen(welcomeScreen)
  }

  override def dispose(): Unit = {
    super.dispose()
    this.welcomeScreen.dispose()
    this.gameOverScreen.dispose()
  }

  def gameOver(): Unit = {
    this.setScreen(gameOverScreen)
  }

  def startGame(): Unit = {
    this.setScreen(new MainGameScreen(this))
  }
}
