import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject, _}
import scalajscrossproject.ScalaJSCrossPlugin.autoImport._

val projectVersion = "0.0.1"

val sharedSettings = Seq(
  name := "game-of-life",
  scalaVersion := "2.12.6"
)

lazy val game = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Dummy)
  .in(file("."))
  .settings(sharedSettings)
  .jsSettings(libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6")
  .jvmSettings(libraryDependencies ++= jvmDependencies)

lazy val gameJS = game.js
lazy val gameJVM = game.jvm

/** Dependencies only used by the JVM project */
lazy val jvmDependencies = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
  "com.typesafe.akka" %% "akka-http" % "10.1.5",
  "com.typesafe.akka" %% "akka-actor" % "2.5.17",
  "com.typesafe.akka" %% "akka-stream" % "2.5.17"
)

/** Dependencies only used by the JS project (note the use of %%% instead of %%) */
// lazy val jsDependencies = Seq(
  // "org.scala-js" %%% "scalajs-dom" % "0.9.6"
// )
