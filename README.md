<div align="center">
  <img 
    src="https://xombitgames.com/wp-content/blogs.dir/27/files/2013/10/ditto-pokemon-x-pokemon-y.jpg" 
    width="150"
  >
</div>

# Ditto Serializer
> My motivation to build this library is because I didn't find a great library for JSON Serialization in Scala as  [ActiveModel::Serializer ](https://github.com/rails-api/active_model_serializers) **or** [fast_jsonapi](https://github.com/Netflix/fast_jsonapi) so I thought, why not to build a pretty DSL for JSON Serialization in this great language?

# Table of Contents

* [Installation](#installation)
* [Usage](#usage)
  * [Serializer Definition](#serializer-definition)
  * [Object Serialization](#object-serialization)
* [Contributing](#contributing)

### DSL

Ditto serializer is very simple we only have 3 helpers in our API for build JSON

1. **attribute**: this helper append to field to the JSON Object
2. **list**: this helper returns a new DittoList this is useful when you need to build a..
3. **map**: this helper returns a new DittoMap this is useful when you need to build a..

### Your first serializer
```scala
import core.Serializer

case class User(firstName: String, lastName: String)

class UserSerializer(val user: User) extends Serializer {
  attribute[String]("name") { user.first_name }
  attribute[String]("last_name") { user.lastName }
  attribute[String]("full_name") { s"${user.name} ${user.lastName}" }
}

// convert to primitive
val primitive = new UserSerializer(User("Jorge", "Hernandez")).serialize.primitiveDeep

```

**Test case:**
```scala
class UserSerializerTest extends FunSpec {
  val serializer = new SimpleSerializer(User("Jorge", "Hernandez"))

  describe("a simple case") {
    it("returns a DittoMap") {
      val data = serializer.serialize

      assert(data.get[String]("name").get == "Jorge")
      assert(data.get[String]("last_name").get == "Hernandez")
      assert(data.get[String]("full_name").get == "Jorge Hernandez")
    }
  }
}
```
### DSL Types
Ditto data types are:

**Number:**  
```scala
attribute[Int]("attribute_name") { 1 }
attribute[Long]("attribute_name") { 1 }
attribute[Float]("attribute name") { 1.1 }
attribute[Double]("attribute name") { 12.22 }
```
**String:**  
```scala
attribute[String]("attribute name") { "hello world" }
```
 **Boolean:**  
```scala
attribute[Boolean]("attribute name") { true }
```
**null:**  
```scala
attribute[Option[Number]]("attribute name") { None }
```
**Object:**  
```scala
attribute[Option[DittoMap]]("attribute name") { map.set("key", "value") }
```
