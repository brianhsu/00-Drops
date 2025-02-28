ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "00-Drops",
    idePackagePrefix := Some("coding.games")
  )

val libGDXVersion = "1.13.1"

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % libGDXVersion,
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % libGDXVersion,
  "com.badlogicgames.gdx" % "gdx-platform" % libGDXVersion classifier("natives-desktop")
)