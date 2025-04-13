package coding.games

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.{Music, Sound}

object Sounds {
  lazy val dropSound: Sound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"))
  lazy val backgroundMusic: Music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"))

  def dispose(): Unit = {
    dropSound.dispose()
    backgroundMusic.dispose()
  }
}
