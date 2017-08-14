// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.9")
// Play Ebean support, to enable, uncomment this line, and enable in your build.sbt using
// enablePlugins(PlayEbean).
addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "3.0.2")
// Play Eclipse support
// Add sbteclipse to your plugin definition file (or create one if doesn't exist)
// execute: sbt eclipse
// https://github.com/typesafehub/sbteclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.1.0")
