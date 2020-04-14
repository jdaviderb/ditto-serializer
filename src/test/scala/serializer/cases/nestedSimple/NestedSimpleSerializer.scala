package serializer.cases.nestedSimple
import org.jdaviderb.dittoSerializer.core.Serializer
import org.jdaviderb.dittoSerializer.types.DittoMap


case class PhoneNumber(code: Int, number: String)
case class Person(firstName: String, lastName: String, phone: PhoneNumber)
case class ClassRoom(name: String, students: List[Person])

class NestedSimpleSerializer extends Serializer {
  attribute[String]("type") { "currencies" }

  attribute[DittoMap]("exchanges") {
    map
      .set[DittoMap]("USD", map.set("rate", 1.0).set("fee", 0.05))
      .set[DittoMap]("EUR", map.set("rate", 1.1).set("fee", 0.02))
      .set[DittoMap]("GBP", map.set("rate", 1.5).set("fee", 0.0))
  }
}
