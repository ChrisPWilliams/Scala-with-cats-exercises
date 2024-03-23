package scalawithcats.exercises

case class Cat(name: String, age: Int, colour: String)

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrinter: Printable[String] = {
    new Printable[String] {
      def format(value: String): String = value
    }
  }
  implicit val intPrinter: Printable[Int] = {
    new Printable[Int] {
      def format(value: Int): String = value.toString
    }
  }

  implicit val catPrinter: Printable[Cat] = {
    new Printable[Cat] {
      def format(value: Cat): String = {
        val name = value.name
        val age = value.age.toString
        val colour = value.colour
        s"$name is a $age year-old $colour cat."
      }
    }
  }
}


object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String = {
      p.format(value)
    }

    def print(implicit p: Printable[A]): Unit = {
      println(p.format(value))
    }
  }
}