package types

class DittoList {
  private var proxy: List[Any] = List()

  def add[T: DittoTypes](value: T): DittoList = {
    value match {
      case dittoMap: DittoMap => proxy = proxy :+ dittoMap
      case dittoList: DittoList => proxy = proxy :+ dittoList.primitive
      case dittoSerializer: DittoSerializer => proxy = proxy :+ dittoSerializer.serialize
      case _ => proxy = proxy :+ value
    }
    this
  }

  def get[T: DittoTypes](index: Int): T = proxy(index).asInstanceOf[T]

  def flatMap(list: List[DittoList]): DittoList = {
    list.foreach { l => proxy = proxy ++ l.primitive }
    this
  }

  def primitive: List[Any] = proxy
}
