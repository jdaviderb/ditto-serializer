package serializer.cases.listSimple

import core.Serializer
import types.DittoList

class ListSimpleSerializer extends Serializer {
  attribute[DittoList]("series") { list.add(0.0).add(0.1).add(0.5).add(1.0).add("end") }
}
