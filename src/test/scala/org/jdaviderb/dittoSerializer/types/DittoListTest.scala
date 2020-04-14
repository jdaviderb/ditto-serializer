package org.jdaviderb.dittoSerializer.types
import org.scalatest.FunSpec

class DittoListTest extends FunSpec {
  describe("#length") {
    it("returns the length of a DittoList") {
      val list = DittoList().add(1).add(2).add(3)

      assert(list.length == 3)
    }
  }

  describe("#primitive") {
    it("returns a list") {
      val list = DittoList().add(1).add(2).add(3)

      assert(list.primitive == List(1, 2, 3))
    }

  }

  describe("#get") {
    it("returns a index") {
      val list = DittoList().add(1).add(2).add("3")

      assert(list.get[Int](0) == 1)
      assert(list.get[Int](1) == 2)
      assert(list.get[String](2) == "3")
    }
  }

  describe("#mapFromPrimitive") {
    it("transform a list primitive to a DittoList") {
      val primitive = List(1, 2, 3, 4)
      val dittoList = DittoList().mapFromPrimitive(primitive) { (dittoList, item) => dittoList.add(item) }

      assert(dittoList.get[Int](0) == 1)
      assert(dittoList.get[Int](1) == 2)
      assert(dittoList.get[Int](2) == 3)
      assert(dittoList.get[Int](3) == 4)
    }
  }
}
