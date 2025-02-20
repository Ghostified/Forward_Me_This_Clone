// Project information
name := "forward_me_this_clone"
version := "1.0"
scalaVersion := "2.13.15"

// Resolving scala-xml conflict
dependencyOverrides += "org.scala-lang.modules" %% "scala-xml" % "1.3.1"

dependencyOverrides += "org.scala-lang" % "scala-library" % "2.13.15"
dependencyOverrides += "org.scala-lang" % "scala-reflect" % "2.13.15"
dependencyOverrides += "org.scala-lang" % "scala-compiler" % "2.13.15"


// Allow minor version differences for scala-xml
libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "early-semver"

val pekkoVersion = "1.0.2"

// Library dependencies
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.8.21",
  "org.playframework.twirl" %% "twirl-api" % "2.0.7",
  "com.typesafe.play" %% "twirl-api" % "1.5.1",
  "org.apache.pekko" %% "pekko-actor" % pekkoVersion,
  "org.apache.pekko" %% "pekko-stream" % pekkoVersion,
  "org.apache.pekko" %% "pekko-http" % pekkoVersion
)

// Enable Play framework plugins
enablePlugins(PlayScala)

// Other settings
fork in run := true
