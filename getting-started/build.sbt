val scala3Version = "3.1.1"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name                            := "scalajs-getting-started",
    version                         := "0.1.0-SNAPSHOT",
    scalaVersion                    := scala3Version,
    scalaJSUseMainModuleInitializer := true,
    jsEnv                           := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv(),
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.1.0",
      "com.lihaoyi"  %%% "utest"       % "0.7.11" % Test
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
