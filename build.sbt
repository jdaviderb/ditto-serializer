githubOwner := "jdaviderb"
githubRepository := "ditto-serializer"
name := "ditto-serializer"
organization := "jdaviderb"
version := "0.5"
scalaVersion := "2.13.1"
publishMavenStyle := true
coverageEnabled := true
coverageHighlighting := true

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.0" % "test"
)
