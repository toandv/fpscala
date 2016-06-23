package fp.week04

/**
  * Created by toan on 6/19/16.
  */
case class X(x: Int)
object PM {
  def pm(x: Any) = {
    x match {
      case  1 => "1"
      case X(n) => "X"
      case _ => "Any"
    }
  }




  def main(args: Array[String]) {
    print(pm(1))
  }
}
