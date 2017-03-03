libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % Test

libraryDependencies += scalaOrganization.value % "scala-compiler" % scalaVersion.value % Provided

libraryDependencies += "org.typelevel" %% "macro-compat" % "1.1.1"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
