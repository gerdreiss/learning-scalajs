enablePlugins(ScalaJSPlugin)

val scala3Version = "3.1.1"

scalaJSUseMainModuleInitializer := true

jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

lazy val root = project
  .in(file("."))
  .settings(
    name                                   := "getting-started",
    version                                := "0.1.0-SNAPSHOT",
    scalaVersion                           := scala3Version,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.1.0"
  )
