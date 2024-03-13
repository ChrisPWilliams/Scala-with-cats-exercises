package scalawithcats.exercises

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrinter: Printable[String] = {
    new Printable[String] {
      override def format(value: String): String = value
    }
  }
  implicit val intPrinter: Printable[Int] = {
    new Printable[Int] {
      override def format(value: Int): String = value.toString
    }
  }

  implicit val catPrinter: Printable[Cat] = {
    new Printable[Cat] {
      override def format(value: Cat): String = {
        val name = Printable.format(value.name)
        val age = Printable.format(value.age)
        val colour = Printable.format(value.colour)
        s"$name is a $age year-old $colour cat."
      }
    }
  }
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = {
    p.format(value)
  }

  def print[A](value: A)(implicit p: Printable[A]): Unit = {
    println(p.format(value))
  }
}
