package fp.week03

/**
  * Created by toan on 6/7/16.
  */
trait Plannar {
  def height: Int

  def width: Int

  @throws(classOf[Exception])
  def square = height * width
}
