package coding.games
package launcher

import coding.games.screen.MainGame
import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object DropsLauncher {

  private val applicationConfiguration = {
    val config = new Lwjgl3ApplicationConfiguration

    config.setTitle("Drops")
    config.setWindowedMode(GameWorld.WIDTH, GameWorld.HEIGHT)
    config.setForegroundFPS(144)
    config.useVsync(false)

    config
  }

  def main(args: Array[String]): Unit = {
    new Lwjgl3Application(new MainGame, applicationConfiguration)
    println("Hello World")
  }
}
