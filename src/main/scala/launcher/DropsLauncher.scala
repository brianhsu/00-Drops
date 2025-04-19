package coding.games
package launcher

import coding.games.core.GameController
import coding.games.screen.MainGameScreen
import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object DropsLauncher {

  private val applicationConfiguration = {
    val config = new Lwjgl3ApplicationConfiguration

    config.setTitle("Drops")
    config.setWindowedMode(1024, 640)
    config.setForegroundFPS(144)
    config.useVsync(false)

    config
  }

  def main(args: Array[String]): Unit = {
    new Lwjgl3Application(new GameController, applicationConfiguration)
    println("Hello World")
  }
}
