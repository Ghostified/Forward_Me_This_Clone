// Project information
name := "forward_me_this_clone"
version := "1.0"
scalaVersion := "2.13.15"

// Add Apache repository where Pekko is hosted
resolvers += "Apache Repository" at "https://repository.apache.org/content/repositories/releases/"

// OPTION 1: For Play 2.8.x (legacy, using Akka)
lazy val root = (project in file("."))
  .enablePlugins(PlayJava)

// Use Akka with Play 2.8.x
val akkaVersion = "2.6.21"

libraryDependencies ++= Seq(
  guice,
  // Play 2.8 dependencies with Akka
  "com.typesafe.play" %% "play" % "2.8.21",
  "com.typesafe.play" %% "play-java" % "2.8.21",
  "com.typesafe.play" %% "play-java-forms" % "2.8.21",
  "com.typesafe.play" %% "twirl-api" % "1.5.1",

  // Akka dependencies
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,

  // Test dependencies
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
)

// Resolving conflicts
dependencyOverrides ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scala-lang.modules" %% "scala-xml" % "2.1.0"
)

// Other settings
fork := true
javacOptions ++= Seq("-source", "11", "-target", "11")

/*
// OPTION 2: For Play 3.x with Pekko (modern)
// Comment out the above and uncomment this section if you want to migrate to Play 3
lazy val root = (project in file("."))
  .enablePlugins(PlayJava)

// Correct Pekko version for Play 3
val pekkoVersion = "1.0.1"

libraryDependencies ++= Seq(
  guice,
  // Play 3.x dependencies
  "org.playframework" %% "play" % "3.0.6",
  "org.playframework" %% "play-java" % "3.0.6",
  "org.playframework" %% "play-java-forms" % "3.0.6",
  "org.playframework.twirl" %% "twirl-api" % "2.0.3",

  // Pekko dependencies
  "org.apache.pekko" %% "pekko-actor-typed" % pekkoVersion,
  "org.apache.pekko" %% "pekko-stream" % pekkoVersion,

  // Test dependencies
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
)

// Resolving conflicts
dependencyOverrides ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scala-lang.modules" %% "scala-xml" % "2.1.0"
)

// Play 3.x settings
PlayKeys.devSettings += "play.server.http.port" -> "9000"

// Other settings
fork := true
javacOptions ++= Seq("-source", "11", "-target", "11")
*/