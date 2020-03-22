package types

case class DittoList private (data: List[Any] = List()) {
  def add[T: DittoTypes](value: T): DittoList = copy(data :+ value)
  def get[T: DittoTypes](index: Int): T = data(index).asInstanceOf[T]
  def primitive: List[Any] = data

  //  def flatMap(list: List[DittoList]): DittoList = {
  //    list.foreach { l => proxy = proxy ++ l.primitive }
  //    this
  //  }
}
