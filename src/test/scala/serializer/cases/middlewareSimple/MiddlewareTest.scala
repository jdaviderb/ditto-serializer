package serializer.cases.middlewareSimple

import org.scalatest.FunSpec

class MiddlewareTest extends FunSpec {
  val serializer = new MiddlewareSimpleSerializer()

  describe("a simple case") {
    it("returns a DittoMap") {
      val data = serializer.serialize

      assert(data.get[String]("environment").get == "production")
    }
  }
}