package coding.games

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

object Textures {
  lazy val bucket: Texture = new Texture(Gdx.files.internal("bucket.png"))
  lazy val drop: Texture = new Texture(Gdx.files.internal("drop.png"))

  def dispose(): Unit = {
    bucket.dispose()
    drop.dispose()
  }
}
