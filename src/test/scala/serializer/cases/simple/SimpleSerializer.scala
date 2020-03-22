package serializer.cases.simple
import core.Serializer

class SimpleSerializer extends Serializer {
  attribute[String]("name") { "Jorge" }
  attribute[String]("last_name") { "Hernandez" }
}
