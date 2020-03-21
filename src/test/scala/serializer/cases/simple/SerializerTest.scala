package serializer.cases.simple
import org.scalatest.FunSpec

class SerializerTest extends FunSpec {
  val serializer = new SimpleSerializer()

  describe("a simple case") {
    it("returns a DittoMap") {
      val data = serializer.serialize

      assert(data.get[String]("name").get == "Jorge")
      assert(data.get[String]("last_name").get == "Hernandez")
    }
  }
}
