package scalawithcats.exercises

import cats.Monoid
import cats.implicits._

object SuperAdder {
  def add[A: Monoid](items: List[A]): A = {
    items.reduce(_ |+| _)
  }
}

case class Order(totalCost: Double, quantity: Double)

object OrderMonoid {
  implicit val addOrders: Monoid[Order] = {
    new Monoid[Order] {
      override def combine(x: Order, y: Order): Order =
        Order(
          totalCost = x.totalCost + y.totalCost,
          quantity = x.quantity + y.quantity
        )
      override def empty: Order =
        Order(
          totalCost = 0,
          quantity = 0
        )
    }
  }
}