package fp.week01

object PascalTriangle extends App {
  for (row <- 0 to 4) {
    for (col <- 0 to row)
      print(pascal(row, col))
    println()
  }

  //@tailrec
  def pascal(row: Int, col: Int): Int = {
    if (col == 0 || col == row)
      1
    else
      pascal(row - 1, col - 1) + pascal(row - 1, col)
  }
}