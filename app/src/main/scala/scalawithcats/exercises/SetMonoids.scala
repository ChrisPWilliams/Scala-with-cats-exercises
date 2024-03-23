package scalawithcats.exercises

import scalawithcats.exercises.customTypeclasses._

object SetMonoidInstances {
  implicit def myUnion[A]: Monoid[Set[A]] = {
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty
      override def combine(x: Set[A], y: Set[A]): Set[A] = x union y
    }
  }
  implicit def myDiff[A]: Monoid[Set[A]] = {
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty
      override def combine(x: Set[A], y: Set[A]): Set[A] = x diff y // no good, this is not associative
    }
  }
  implicit def myIntersect[A]: Semigroup[Set[A]] = {
    new Semigroup[Set[A]] {
      override def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
    }
  }

}