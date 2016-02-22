package week01

object session01 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(8); val res$0 = 
  1 + 2;System.out.println("""res0: Int(3) = """ + $show(res$0));$skip(44); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(302); 

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double = if (isGoodEnough(guess)) guess else (sqrtIter(improve(guess)))

    def isGoodEnough(guess: Double): Boolean = abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double = (guess + x / guess) / 2

    sqrtIter(1)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$1 = 

  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(14); val res$2 = 

  sqrt(1e60);System.out.println("""res2: Double = """ + $show(res$2))}
}
