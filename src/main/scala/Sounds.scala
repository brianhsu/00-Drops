package coding.games

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.{Music, Sound}

object Sounds {
  val dropSound: Sound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"))
  val backgroundMusic: Music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"))

  def dispose(): Unit = {
    dropSound.dispose()
    backgroundMusic.dispose()
  }
}
