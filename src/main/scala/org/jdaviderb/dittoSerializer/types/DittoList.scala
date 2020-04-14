package org.jdaviderb.dittoSerializer.types

case class DittoList private (data: List[Any] = List()) {
  def add[T: DittoTypes](value: T): DittoList = copy(data :+ value)
  def get[T: DittoTypes](index: Int): T = data(index).asInstanceOf[T]
  def primitive: List[Any] = data
  def length: Int = data.length

  def mapFromPrimitive[T](list: List[T])(callback: (DittoList, T) => DittoList): DittoList = {
    var result: DittoList = this
    list.foreach((row) => result = callback(result, row))
    result
  }
}
