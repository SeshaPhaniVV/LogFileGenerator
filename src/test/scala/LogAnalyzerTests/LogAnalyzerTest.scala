package vvakic2.uic.cs441
package LogAnalyzerTests

import LogAnalyzerTasks.Task1.{Task1Mapper, Task1Reducer}
import LogAnalyzerTasks.Task2.{Task2Mapper1, Task2Mapper2, Task2Reducer1, Task2Reducer2}
import LogAnalyzerTasks.Task3.{Task3Mapper, Task3Reducer}
import LogAnalyzerTasks.Task4.{Task4Mapper, Task4Reducer}
import LogAnalyzerTasks.{Task1, Task2, Task3, Task4}

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.mapreduce.Job
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers.*
import org.slf4j.{Logger, LoggerFactory}

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import scala.util.matching.Regex

class LogAnalyzerTest extends AnyFlatSpec with Matchers {
  val config: Config = ConfigFactory.load("application.conf")

  it should "check if config file is present" in {
    val config: Config = ConfigFactory.load("application.conf")
    assert(!config.isEmpty)
  }

  it should "check if logger is initialized properly" in {
    val log = LoggerFactory.getLogger(getClass)
    assert(log.isInstanceOf[Logger])
  }

  it should "mapper class should match" in {
    val configure: Configuration = new Configuration()
    val task1                    = Job.getInstance(configure, "test1 mapReduce")
    task1.setMapperClass(classOf[Task1Mapper])
    assert(task1.getMapperClass == classOf[Task1Mapper])
  }

  it should "reducer class should match" in {
    val configure1: Configuration = new Configuration()
    val task1                     = Job.getInstance(configure1, "test1 mapReduce")
    task1.setReducerClass(classOf[Task1Reducer])
    assert(task1.getReducerClass == classOf[Task1Reducer])
  }

  it should "check regex pattern" in {
    val string =
      "12:01:40.935 [scala-execution-context-global-16] WARN  HelperUtils.Parameters$ - x2oBSI0/\\%CdfV2%ChSsnZ7vJo=2qJqZ%.\"kbc!0ne`y&m"
    val keyValPattern: Regex = config.getString("logAnalyzer.regexPattern").r

    val isPattern = keyValPattern.findFirstMatchIn(string) match {
      case Some(_) => true
      case None    => false
    }
    assert(isPattern)
  }
}
