package org.jdaviderb.dittoSerializer.core

import org.jdaviderb.dittoSerializer.types.{DittoMap, Middleware}

final class MiddlewareManager {
  var middlewares: List[Middleware] = List()

  def add(middleware: Middleware): MiddlewareManager = {
    middlewares = middlewares :+ middleware
    this
  }

  def apply(data: DittoMap): DittoMap =
    middlewares.foldLeft(data) { (map, middleware) => middleware.apply(map) }
}
