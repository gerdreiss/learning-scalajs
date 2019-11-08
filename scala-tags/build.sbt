lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin, WorkbenchPlugin)
  .settings(
    inThisBuild(List(
      organization := "com.github",
      version      := "0.1-SNAPSHOT",
      scalaVersion := "2.13.1"
    )),
    name := "scala-tags",
    libraryDependencies ++= Seq(
      "org.scala-js"  %%% "scalajs-dom" % "0.9.7",
      "com.lihaoyi"   %%% "scalatags"   % "0.7.0",
      "org.scalatest" %%% "scalatest"   % "3.0.8"  % "test"
    )
  )


// Automatically generate index-dev.html which uses *-fastopt.js
// resourceGenerators in Compile += Def.task {
//   val source = (resourceDirectory in Compile).value / "index.html"
//   val target = (resourceManaged in Compile).value / "index-dev.html"

//   val fullFileName = (artifactPath in (Compile, fullOptJS)).value.getName
//   val fastFileName = (artifactPath in (Compile, fastOptJS)).value.getName

//   IO.writeLines(target,
//     IO.readLines(source).map {
//       line => line.replace(fullFileName, fastFileName)
//     }
//   )

//   Seq(target)
// }.taskValue
