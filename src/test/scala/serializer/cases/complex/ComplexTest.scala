package serializer.cases.complex

import java.util.UUID.randomUUID

import org.scalatest.FunSpec
import org.jdaviderb.dittoSerializer.types.{DittoList, DittoMap}


class ComplexTest extends FunSpec {
  val jorge = Person(randomUUID(), "Jorge", "Hernandez", PhoneNumber(code = 58, number = "7870751"))
  val larry = Person(randomUUID(), "Larry", "Hernandez", PhoneNumber(code = 58, number = "7820752"))
  val room = ClassRoom(name = "Test #1", students =  List(jorge, larry))
  val serializer = new ComplexSerializer(room)


  describe("a simple case") {
    it("returns a DittoMap") {
      val data = serializer.serialize
      val students = data.get[DittoList]("students").get

      assert(data.get[String]("name").get == "Test #1")
      assert(students.get[DittoMap](0).get[String]("id").get == jorge.id.toString)
      assert(students.get[DittoMap](0).get[String]("first_name").get == jorge.firstName)
      assert(students.get[DittoMap](0).get[String]("last_name").get == jorge.lastName)
      assert(students.get[DittoMap](0).get[String]("full_name").get == "Jorge Hernandez")
      assert(students.get[DittoMap](1).get[String]("id").get == larry.id.toString)
      assert(students.get[DittoMap](1).get[String]("first_name").get == larry.firstName)
      assert(students.get[DittoMap](1).get[String]("last_name").get == larry.lastName)
      assert(students.get[DittoMap](1).get[String]("full_name").get == "Larry Hernandez")
    }
  }
}
