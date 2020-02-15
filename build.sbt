import sbt.Keys.scalaVersion

name := "shoonya-blog"

version := "0.1"

scalaVersion := "2.13.1"

val SilencerVersion = "1.4.4"

val baseDeps = Seq()

val _scalacOptions = Seq(
    "-feature",
    "-deprecation",
    "-explaintypes",
    "-unchecked",
    "-encoding",
    "UTF-8",
    "-language:higherKinds",
    "-language:existentials",
    "-Xfatal-warnings",
    "-Xlint:-infer-any,_",
    "-Ymacro-annotations",
    "-Ywarn-value-discard",
    "-Ywarn-numeric-widen",
    "-Ywarn-extra-implicit",
    "-Ywarn-unused:_",
    "-opt:l:inline"
)

val _compilerPlugins = Seq(
    // plugins
    ("com.github.ghik" % "silencer-lib" % SilencerVersion % Provided).cross(CrossVersion.full),
    compilerPlugin(("com.github.ghik" % "silencer-plugin" % SilencerVersion).cross(CrossVersion.full)),
    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    compilerPlugin(("org.typelevel" % "kind-projector" % "0.11.0").cross(CrossVersion.full))
)

lazy val root = (project in file("."))
  .settings(
    name := "shoonya-blog",
    scalaVersion := "2.13.1",
    scalacOptions := _scalacOptions,
    libraryDependencies ++= baseDeps ++ _compilerPlugins,
    fork in (run) := true
  )

lazy val docs = project
  .in(file("shoonya-blog-docs"))
  .settings(
    skip.in(publish) := true,
    moduleName := "shoonya-blog-docs",
    scalaVersion := "2.13.1",
    scalacOptions := _scalacOptions,
    unidocProjectFilter in (ScalaUnidoc, unidoc) := inProjects(root),
    target in (ScalaUnidoc, unidoc) := (baseDirectory in LocalRootProject).value / "website" / "static" / "api",
    cleanFiles += (target in (ScalaUnidoc, unidoc)).value,
    docusaurusCreateSite := docusaurusCreateSite.dependsOn(unidoc in Compile).value,
    docusaurusPublishGhpages := docusaurusPublishGhpages.dependsOn(unidoc in Compile).value
  )
  .dependsOn(root)
  .enablePlugins(MdocPlugin, DocusaurusPlugin, ScalaUnidocPlugin)