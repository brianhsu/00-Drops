package coding.games

import com.badlogic.gdx.utils.viewport.FitViewport

object GameWorld {
  val WIDTH = 102 // 102 公分
  val HEIGHT = 64 // 64 公分

  val FIT_VIEWPORT = new FitViewport(GameWorld.WIDTH, GameWorld.HEIGHT)
  val UI_VIEWPORT = new FitViewport(1024, 640)
}
