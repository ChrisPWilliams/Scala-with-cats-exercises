package scalawithcats.exercises

trait Semigroup[A] {
  def combine(x: A, y: A): A
}
trait Monoid[A] extends Semigroup[A] {
  def empty: A
}
object Monoid {
  def apply[A](implicit monoid: Monoid[A]) =
    monoid
}

object BooleanMonoidInstances {
  implicit val myOr: Monoid[Boolean] = {
    new Monoid[Boolean] {
      def empty = false
      def combine(x: Boolean, y: Boolean) = x | y
    }
  }
  implicit val myAnd: Monoid[Boolean] = {
    new Monoid[Boolean] {
      def empty: Boolean = true
      def combine(x: Boolean, y: Boolean) = x && y
    }
  }
  implicit val myXNor: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def empty: Boolean = true
      override def combine(x: Boolean, y: Boolean): Boolean = !((x | y) && !(x && y))
    }
  }
  implicit val myNand: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def empty: Boolean = false
      override def combine(x: Boolean, y: Boolean): Boolean = !(x && y)
    }
  }
}