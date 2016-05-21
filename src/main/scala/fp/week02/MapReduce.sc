import scala.annotation.tailrec

def mapReduce(combine: (Int, Int) => Int, zero: Int)(map: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) zero
  else combine(map(a), mapReduce(combine, zero)(map)(a + 1, b))
}

@tailrec
def mapReduce1(combine: (Int, Int) => Int, acc: Int)(map: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) acc
  else mapReduce1(combine, combine(map(a), acc))(map)(a + 1, b)
}

def sum1 = mapReduce((a, b) => a + b, 0) _

def sum2 = mapReduce1((a, b) => a + b, 0) _
sum1(x => x)(1, 3)
