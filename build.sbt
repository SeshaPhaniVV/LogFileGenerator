name := "LogFileGenerator"

version := "1"

scalaVersion := "3.2.0"

val logbackVersion        = "1.4.1"
val sfl4sVersion          = "2.0.1"
val typesafeConfigVersion = "1.4.2"
val apacheCommonIOVersion = "2.11.0"
val scalacticVersion      = "3.2.12"
val generexVersion        = "1.0.2"

resolvers += Resolver.jcenterRepo

lazy val root = (project in file("."))
  .settings(
    name                 := "LogFileGenerator",
    idePackagePrefix     := Some("vvakic2.uic.cs441"),
    assembly / mainClass := Some("vvakic2.uic.cs441.GenerateLogData")
  )

libraryDependencies ++= Seq(
  "ch.qos.logback"    % "logback-core"          % logbackVersion,
  "ch.qos.logback"    % "logback-classic"       % logbackVersion,
  "org.slf4j"         % "slf4j-api"             % sfl4sVersion,
  "com.typesafe"      % "config"                % typesafeConfigVersion,
  "commons-io"        % "commons-io"            % apacheCommonIOVersion,
  "org.scalactic"    %% "scalactic"             % scalacticVersion,
  "org.scalatest"    %% "scalatest"             % scalacticVersion % Test,
  "org.scalatest"    %% "scalatest-featurespec" % scalacticVersion % Test,
  "com.github.mifmif" % "generex"               % generexVersion
)

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x                             => MergeStrategy.first
}
