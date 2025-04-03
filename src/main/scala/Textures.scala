package coding.games

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

object Textures {
  lazy val bucket: Texture = new Texture(Gdx.files.internal("bucket.png"))
  lazy val drop: Texture = new Texture(Gdx.files.internal("drop.png"))
  lazy val background: Texture = new Texture(Gdx.files.internal("background.png"))

  def dispose(): Unit = {
    bucket.dispose()
    drop.dispose()
    background.dispose()
  }
}
