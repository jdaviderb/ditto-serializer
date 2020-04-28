<div align="center">
  <img
    src="https://xombitgames.com/wp-content/blogs.dir/27/files/2013/10/ditto-pokemon-x-pokemon-y.jpg"
    width="150"
  >
</div>

> My motivation to build this library is because I didn't find a great library for JSON Serialization in Scala as  [ActiveModel::Serializer ](https://github.com/rails-api/active_model_serializers) **or** [fast_jsonapi](https://github.com/Netflix/fast_jsonapi) so I thought, why not to build a pretty DSL for JSON Serialization in this great language?

<div align="center">
  <p>
    <sub>Built with ❤︎ by <a href="https://github.com/jdaviderb">jdavierb</a></sub>
  </p>
</div>

# ✨ Features

- ❤️ DSL similar to Active Model Serializer
- ✅  Support encoders for JSON Serialization like Circle, Spray
- 👋 Easy to test


# 📜 Table of Contents

* [Installation](#installation)
* [Usage](#usage)
  * [Serializer Definition](#serializer-definition)
  * [Object Serialization](#object-serialization)
* [JSON Serialization](#json-serialization)
  * [Using circle](#using-circle)
  * [Using spray-json](#using-spray-json)

### Installation

If you use SBT you can add ditto-serializer in your project with

```sbt
externalResolvers += "ditto-serializer" at "https://maven.pkg.github.com/jdaviderb/ditto-serializer"

libraryDependencies += "jdaviderb" %%  "ditto-serializer" % "0.5.0"
```

### DSL

Ditto serializer is very simple we only have 3 helpers in our API for build JSON

1. **attribute[T]**: this helper append to field to the JSON Object
2. **list**: this helper returns a new instance of  DittoList **(Array)** you can add new a element using the method `add` example: `list.add("new item")`
3. **map**: this helper returns a new instance of DittoMap [JsonObject] you can add a new **(key, value)** using the method `set` example: `map.set("key", "value")`


### Model Definition

```scala
case class User(firstName: String, lastName: String)
```

### Serializer Definitation
```scala
import org.jdaviderb.dittoSerializer.core.Serializer

class UserSerializer(val user: User) extends Serializer {
  attribute("name") { user.firstName }
  attribute("last_name") { user.lastName }
  attribute("full_name") { s"${user.firstName} ${user.lastName}" }
}
```
<div align="left">
  <p>
    <sub><a href="https://github.com/jdaviderb">Complex Example</a></sub>
  </p>
</div>

### JSON Serialization

### Using Circle
if you want to use Circle for JSON Serialization, you have to add this package in your project

```sbt
externalResolvers += "ditto-circle" at "https://maven.pkg.github.com/jdaviderb/ditto-circle"

libraryDependencies += "jdaviderb" %%  "ditto-circle" % "0.5.0"
```

**Example:**

```scala
import org.jdaviderb.DittoCircle.Enconder
import org.jdaviderb.dittoSerializer.core.Serializer

// Model definition
case class User(firstName: String, lastName: String)

// Serializer
class UserSerializer(val user: User) extends Serializer {
  attribute("name") { user.firstName }
  attribute("last_name") { user.lastName }
  attribute("full_name") { s"${user.firstName} ${user.lastName}" }
}

// JSON Serialization
val jorge = User("Jorge", "Hernandez")
val josue = User("Josue", "Hernandez")
val users = List(jorge, josue)

Enconder.from(new UserSerializer(jorge))
/*
  RESULT:
  {
    "full_name" : "Jorge Hernandez",
    "last_name" : "Hernandez",
    "name" : "Jorge"
  }
*/

Enconder.fromList(users.map(new UserSerializer(_)))
/*
  RESULT:
  [
    {
      "full_name" : "Jorge Hernandez",
      "last_name" : "Hernandez",
      "name" : "Jorge"
    },
    {
      "full_name" : "Josue Hernandez",
      "last_name" : "Hernandez",
      "name" : "Josue"
    }
  ]
*/

```

### Using Spray

> Pending

### Using Json4s

> Pending
