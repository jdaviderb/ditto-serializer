package org.jdaviderb.dittoSerializer.types

trait Middleware {
  def apply(data: DittoMap): DittoMap
}
