/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package scalawithcats.exercises

import cats._
import cats.implicits._

final case class Cat(name: String, age: Int, colour: String)

object App {
  def main(args: Array[String]): Unit = {
    implicit val catShow: Show[Cat] =
      new Show[Cat] {
        def show(c: Cat): String = s"${c.name} is a ${c.age.toString} year-old ${c.colour} cat."
      }

    val cat = Cat(
      name = "Sherlock",
      age = 3,
      colour = "black"
    )
    println(cat.show)
  }

}
