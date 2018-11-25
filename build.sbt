import sbtcrossproject.CrossPlugin.autoImport.crossProject
import sbtcrossproject.CrossType

lazy val frontEnd = (project in file("front-end"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := "2.12.6",
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.6",
      "com.typesafe.play" %%% "play-json" % "2.6.0",
      "org.querki" %%% "jquery-facade" % "1.2"
    ),
    jsDependencies += "org.webjars" % "jquery" % "2.2.1" / "jquery.js" minified "jquery.min.js"
  ) dependsOn sharedJS

lazy val backEnd = (project in file("back-end"))
  .settings(
    resolvers += Resolver.bintrayRepo("hseeberger", "maven"),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.17",
      "com.typesafe.akka" %% "akka-http" % "10.1.5",
      "de.heikoseeberger" %% "akka-http-circe" % "1.20.0",
      "de.heikoseeberger" %% "akka-http-play-json" % "1.20.0",
      "com.typesafe.akka" %% "akka-slf4j" % "2.5.17"
    )
  ) dependsOn sharedJVM

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-json" % "2.6.0",
    )
  )

lazy val sharedJVM = shared.jvm
lazy val sharedJS = shared.js
