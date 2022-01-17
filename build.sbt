name := "eureka"
organization := "eu.shooktea"

version := sys.env.getOrElse("ARTIFACT_VERSION", "0.0.0-SNAPSHOT")

scalaVersion := "2.13.8"
crossPaths := false

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test

publishTo := Some("GitHub ShookTea Apache Maven Packages" at "https://maven.pkg.github.com/ShookTea/ScalaEureka")
publishMavenStyle := true
credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  "ShookTea",
  System.getenv("GITHUB_TOKEN")
)