

def even: Int => Boolean = _ % 2 == 0
lazy val even1: Int => Boolean = _ % 2 == 0


even.hashCode()
even1.hashCode()
even.hashCode()
even1.hashCode()

even(3)
even1(3)
even1(5)


