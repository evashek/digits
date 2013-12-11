name := "digits"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.21",
  "org.webjars"   %% "webjars-play"  % "2.2.0",
  // Downgrade to JQuery 1.8.3 so that integration tests with HtmlUnit work.
  "org.webjars" % "bootstrap" % "3.0.0" exclude("org.webjars", "jquery"),
  "org.webjars" % "jquery" % "1.8.3"
) 

play.Project.playJavaSettings

resolvers ++= Seq(
  "webjars" at "http://webjars.github.com/m2"
)