package org.jdaviderb.dittoSerializer.types

trait DittoTypes[T]

object DittoTypes {
  implicit object stringType extends DittoTypes[Int]
  implicit object doubleType extends DittoTypes[Double]
  implicit object longType extends DittoTypes[Long]
  implicit object floatType extends DittoTypes[Float]
  implicit object boolType extends DittoTypes[Boolean]
  implicit object bigIntType extends DittoTypes[BigInt]
  implicit object bigDecimalType extends DittoTypes[BigDecimal]
  implicit object intType extends DittoTypes[String]
  implicit object dittoMapType extends DittoTypes[DittoMap]
  implicit object dittoListType extends DittoTypes[DittoList]
  implicit object dittoSerializeType extends DittoTypes[DittoSerializer]
}