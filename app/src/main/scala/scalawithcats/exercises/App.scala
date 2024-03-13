/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package scalawithcats.exercises

import scalawithcats.exercises.PrintableInstances._
import scalawithcats.exercises.PrintableSyntax._

final case class Cat(name: String, age: Int, colour: String)

object App {
  def main(args: Array[String]): Unit = {
    val cat = Cat(
      name = "Sherlock",
      age = 3,
      colour = "black"
    )
    cat.print
  }

}
