package coding.games
package core

import sprite.{Bucket, Drop}

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class DropsController(bucket: Bucket, scoreController: ScoreController) {
  private var drops: List[Drop] = Nil

  private var timerInSeconds: Float = 100

  def updateGameWorld(): Unit = {
    timerInSeconds += Gdx.graphics.getDeltaTime

    if (timerInSeconds >= 2) {
      println("drop.size:" + drops.size)
      drops ::= new Drop
      timerInSeconds = 0
    }

    drops.foreach(_.updateGameWorld())
    drops = drops.filterNot(isLostLife)
      .filterNot(isDropCaught)
  }

  private def isLostLife(drop: Drop): Boolean = {
    val isFallout = drop.isFalloutOfScreen

    if (isFallout) {
      scoreController.lostLife()
    }

    isFallout
  }

  private def isDropCaught(drop: Drop): Boolean = {
    val isCaught = bucket.collisionArea.overlaps(drop.collisionArea)

    if (isCaught) {
      Sounds.dropSound.play()
      scoreController.scored()
    }

    isCaught
  }

  def draw(spriteBatch: SpriteBatch): Unit = {
    drops.foreach(_.draw(spriteBatch))
  }
}
