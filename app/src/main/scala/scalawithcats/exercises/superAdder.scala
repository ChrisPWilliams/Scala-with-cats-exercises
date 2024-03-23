package scalawithcats.exercises

import cats.Monoid
import cats.implicits._

object SuperAdder {
  def add[A: Monoid](items: List[A]): A = {
    items.reduce(_ |+| _)
  }
}