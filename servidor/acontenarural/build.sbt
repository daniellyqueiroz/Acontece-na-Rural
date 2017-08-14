import play.ebean.sbt.PlayEbean

name := """aconteNaRural"""
organization := "com.aconteceNaRural"

version := "1.0-SNAPSHOT"

lazy val root= (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(

 javaJdbc,
 javaJpa,
 cache,
 filters,
 evolutions,
 javaWs
)
