package org.jdaviderb.dittoSerializer.middlewares

import org.jdaviderb.dittoSerializer.types.Middleware
import org.jdaviderb.dittoSerializer.types.DittoMap

class UnderscoreMiddleware extends Middleware {
  def apply(data: DittoMap): DittoMap = data
}
