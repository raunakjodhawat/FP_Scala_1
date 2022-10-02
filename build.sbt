ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

lazy val root = (project in file("."))
  .settings(
    name := "FP_Scala_1",
    idePackagePrefix := Some("com.raunakjodhawat")
  )
