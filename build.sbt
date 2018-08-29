name := "Collections"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test,
  //"org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.5" % "test",
  "com.storm-enroute" %% "scalameter" % "0.9" % "test" excludeAll ExclusionRule(organization = "org.mongodb"),
  "com.typesafe.akka" %% "akka-actor" % "2.5.11",
  "com.typesafe.akka" % "akka-stream_2.12" % "2.5.11",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.11",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.11" % "test",
  "com.typesafe.akka" %% "akka-http" % "10.1.0",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.0" % "test",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.0",
  "io.spray" %% "spray-json" % "1.3.4",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.5",
  //  "org.postgresql" % "postgresql" % "42.2.2",
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "org.tpolecat" %% "doobie-core" % "0.5.1",
  "org.scalikejdbc" %% "scalikejdbc" % "3.2.3",
  "org.scalikejdbc" %% "scalikejdbc-config" % "3.2.3",
  "org.scalikejdbc" %% "scalikejdbc-test" % "3.2.3" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.1",
  "com.zaxxer" % "HikariCP" % "3.2.0",
  "com.typesafe.play" %% "anorm" % "2.5.3",
  "org.mongodb" %% "casbah" % "3.1.1",
  "com.github.salat" %% "salat" % "1.11.2",
  "org.scala-lang.modules" %% "scala-async" % "0.9.7",
  "com.github.fakemongo" % "fongo" % "2.1.0",
  "com.chuusai" %% "shapeless" % "2.3.3",
  //https://github.com/bean-validation-scala/bean-validation-scala
  "com.tsukaby" %% "bean-validation-scala" % "0.4.2",
  //https://github.com/t3hnar/scala-bcrypt
  "com.github.t3hnar" %% "scala-bcrypt" % "3.1",
  //https://github.com/softwaremill/akka-http-session/blob/master/example/src/main/scala/com/softwaremill/example/ScalaExample.scala
  "com.softwaremill.akka-http-session" %% "core" % "0.5.5",
  // https://mvnrepository.com/artifact/mysql/mysql-connector-java
  "mysql" % "mysql-connector-java" % "8.0.11",
  //  "com.h2database" % "h2" % "1.4.197" % Test,
  "com.h2database" % "h2" % "1.4.197",
  "junit" % "junit" % "4.12" % Test,
  "org.junit.jupiter" % "junit-jupiter-api" % "5.2.0" % Test,
  "org.junit.jupiter" % "junit-jupiter-engine" % "5.2.0" % Test,
  "org.junit.jupiter" % "junit-jupiter-params" % "5.2.0" % Test,
  "org.junit.platform" % "junit-platform-launcher" % "1.2.0" % Test,
  "org.junit.platform" % "junit-platform-engine" % "1.2.0" % Test,
  "org.junit.platform" % "junit-platform-runner" % "1.2.0" % Test,

  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"


)

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

parallelExecution in Test := false

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)