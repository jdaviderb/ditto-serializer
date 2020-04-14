package serializer.cases.nestedSimple
import org.scalatest.FunSpec
import org.jdaviderb.dittoSerializer.types.DittoMap

class NestedSimpleTest extends FunSpec {
  val serializer = new NestedSimpleSerializer

  describe("simple nested") {
    it("return a DittoMap") {
      val data = serializer.serialize
      val exchanges = data.get[DittoMap]("exchanges").get

      assert(data.get[String]("type").get == "currencies")

      // USD CASES
      assert(exchanges.get[DittoMap]("USD").get.get[Double]("rate").get == 1.0)
      assert(exchanges.get[DittoMap]("USD").get.get[Double]("fee").get == 0.05)

      // EUR CASES
      assert(exchanges.get[DittoMap]("EUR").get.get[Double]("rate").get == 1.1)
      assert(exchanges.get[DittoMap]("EUR").get.get[Double]("fee").get == 0.02)

      // GBP CASES
      assert(exchanges.get[DittoMap]("GBP").get.get[Double]("rate").get == 1.5)
      assert(exchanges.get[DittoMap]("GBP").get.get[Double]("fee").get == 0.0)
    }
  }
}
