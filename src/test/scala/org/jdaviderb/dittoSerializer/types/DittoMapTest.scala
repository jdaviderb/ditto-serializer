package org.jdaviderb.dittoSerializer.types
import org.scalatest.FunSpec

class DittoMapTest extends FunSpec {

  describe("#get") {
    it("returns primitives values") {
      val map = DittoMap().set("hello", "world").set("scala", "awesome")
      assert(map.get[String]("hello").get == "world")
      assert(map.get[String]("scala").get == "awesome")
    }

    it("returns a map") {
      val child = DittoMap().set("name", "child")
      val map = DittoMap().set("child", child)

      assert(map.get[DittoMap]("child").get == child)
    }

    it("returns a list") {
      val map = DittoMap().set("list",  DittoList().add(1).add(2).add(3))

      assert(map.get[DittoList]("list").get == DittoList().add(1).add(2).add(3))
    }
  }

  describe("#set") {
    val map = DittoMap().set("creator", "mock")

    it("returns a new map") {
      assert(map.set("creator", "Jorge").get[String]("creator").get == "Jorge")
    }
  }

  describe("#primitive") {
    it("returns a amp") {
      val details = DittoMap().set("age", "27")
      val map = DittoMap().set("name", "Jorge").set("details", details).primitive

      assert(map.get("name").get == "Jorge")
      assert(map.get("details").get == details)
    }
  }

  describe("#primitiveDeep") {
    it("transforms all values to primitive") {
      val details = DittoMap().set("age", "27")
      val map = DittoMap().set("name", "Jorge").set("details", details).primitiveDeep.primitive

      assert(map.get("name").get == "Jorge")
      assert(map.get("details").get == details.primitiveDeep.primitive)
    }

  }

  describe("#mapKeysDeep") {
    it("map keys") {
      val details = DittoMap().set("age", "27")
      val map = DittoMap().set("name", "Jorge").set("details", details).mapKeysDeep(name => name + "_deep")
      val childExpected = map.primitiveDeep.primitive.get("details_deep").get.asInstanceOf[Map[String, Any]]

      assert(map.primitiveDeep.primitive.get("name_deep").get == "Jorge")
      assert(childExpected.get("age_deep").get == "27")
    }

  }
}
