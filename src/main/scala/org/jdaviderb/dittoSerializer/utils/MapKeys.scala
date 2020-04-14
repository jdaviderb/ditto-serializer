package org.jdaviderb.dittoSerializer.utils

object MapKeys {
  def transformDeepKeys(data: Map[String, Any])(transformKey: (String) => String): Map[String, Any] =
    data.map { case (key, value) => (transformKey(key), deep(value, transformKey))  }

  private def deep(value: Any, transformKey: (String) => String): Any = value match {
    case list: List[Any] => list.map { row => deep(row, transformKey) }
    case data: Map[String, Any] => transformDeepKeys(data) { key => transformKey(key) }
    case _ => value
  }
}
