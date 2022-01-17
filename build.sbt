name := "ScalaEureka"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test

publishTo := Some("GitHub ShookTea Apache Maven Packages" at "https://maven.pkg.github.com/ShookTea/ScalaEureka")
publishMavenStyle := true
credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  "ShookTea",
  System.getenv("GITHUB_TOKEN")
)