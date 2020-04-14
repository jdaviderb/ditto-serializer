package serializer.cases.simple
import org.jdaviderb.dittoSerializer.core.Serializer

class SimpleSerializer(val user: User) extends Serializer {
  attribute[String]("name") { user.firstName }
  attribute[String]("last_name") { user.lastName }
  attribute[String]("full_name") { s"${user.firstName} ${user.lastName}" }
}
