package scalawithcats.exercises

object SetMonoidInstances {
  implicit val myUnion: Monoid[Set[_]] = {
    new Monoid[Set[_]] {
      override def empty: Set[_] = Set.empty
      override def combine(x: Set[_], y: Set[_]): Set[_] = x union y
    }
  }
  implicit val myDiff: Monoid[Set[_]] = {
    new Monoid[Set[_]] {
      override def empty: Set[_] = Set.empty
      override def combine(x: Set[_], y: Set[_]): Set[_] = x diff y
    }
  }
  implicit val myIntersect: Semigroup[Set[_]] = {
    new Semigroup[Set[_]] {
      override def combine(x: Set[_], y: Set[_]): Set[_] = x intersect y
    }
  }

}