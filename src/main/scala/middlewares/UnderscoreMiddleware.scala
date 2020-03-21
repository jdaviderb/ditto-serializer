package middlewares

import types.Middleware
import types.DittoMap

class UnderscoreMiddleware extends Middleware {
  def apply(data: DittoMap): DittoMap = data
}
