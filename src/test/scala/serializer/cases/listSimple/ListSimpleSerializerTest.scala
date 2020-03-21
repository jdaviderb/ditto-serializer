package serializer.cases.listSimple

import org.scalatest.FunSpec
import types.DittoList

class ListSimpleSerializerTest extends FunSpec {
  val serializer = new ListSimpleSerializer()

  describe("a list simple case") {
    it("returns a DittoMap") {
      val data = serializer.serialize
      val list = data.get[DittoList]("series").get

      assert(list.get[Double](0) == 0.0)
      assert(list.get[Double](1) == 0.1)
      assert(list.get[Double](2) == 0.5)
      assert(list.get[Double](3) == 1.0)
      assert(list.get[String](4) == "end")
    }
  }
}
