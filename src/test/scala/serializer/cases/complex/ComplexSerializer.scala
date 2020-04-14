package serializer.cases.complex
import org.jdaviderb.dittoSerializer.core.Serializer
import java.util.UUID

case class PhoneNumber(code: Int, number: String)
case class Person(id: UUID, firstName: String, lastName: String, phone: PhoneNumber)
case class ClassRoom(name: String, students: List[Person])

class ComplexSerializer(room: ClassRoom) extends Serializer {
  attribute("name") { room.name }
  attribute("students") {
    list.mapFromPrimitive[Person](room.students) { (list, student) =>
      val phoneMap = map
        .set("code", student.phone.code)
        .set("number", student.phone.number)

      val studentMap = map
        .set("id", student.id.toString)
        .set("first_name", student.firstName)
        .set("last_name", student.lastName)
        .set("full_name", s"${student.firstName} ${student.lastName}")
        .set("phone", phoneMap)

      list.add(studentMap)
    }
  }
}
