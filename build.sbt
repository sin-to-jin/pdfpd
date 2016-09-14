name := """pdfpd"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

resolvers ++= Seq()

libraryDependencies ++= List(
  "it.innove" % "play2-pdf" % "1.5.1",
  "com.typesafe.slick" %% "slick" % "3.1.1"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"