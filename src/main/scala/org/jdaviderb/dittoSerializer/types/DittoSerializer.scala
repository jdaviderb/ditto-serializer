package org.jdaviderb.dittoSerializer.types

trait DittoSerializer {
  var data: DittoMap

  def attribute[T: DittoTypes](key: String)(callback: => T ): T
  def serialize: DittoMap
}
