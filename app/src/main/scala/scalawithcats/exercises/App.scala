/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package scalawithcats.exercises

import cats._
import cats.implicits._

final case class Cat(name: String, age: Int, colour: String)

object App {
  def main(args: Array[String]): Unit = {
    implicit val catEq: Eq[Cat] = Eq.instance[Cat] {
      (cat1, cat2) =>
        cat1.name === cat2.name && cat1.age === cat2.age && cat1.colour === cat2.colour
    }

    val cat1 = Cat(
      name = "Sherlock",
      age = 3,
      colour = "black"
    )
    val cat2 = Cat(
      name = "Garfield",
      age = 25,
      colour = "orange"
    )

    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]

    println(cat1 === cat2)
    println(optionCat1 === optionCat2)
  }

}
