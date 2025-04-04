package coding.games
package core

import sprite.{Bucket, Drop}

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class DropsController(bucket: Bucket) {

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
    drops = drops.filterNot(_.isFalloutOfScreen).filterNot(isCaught)
  }

  private def isCaught(drop: Drop): Boolean = {
    val isOverlapped = drop.collisionArea.overlaps(bucket.collisionArea)

    if (isOverlapped) {
      Sounds.dropSound.play()
    }

    isOverlapped
  }

  def draw(spriteBatch: SpriteBatch): Unit = {
    drops.foreach(_.draw(spriteBatch))
  }
}
