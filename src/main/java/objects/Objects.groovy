package objects

import objects.Person

wu
//为类动态添加一个属性
Person.metaClass.sex = 'male'

def person = new Person(name: 'Ondroid', age: 27)

//groovy 中通过.访问字段本质上都是通过getter/setter方法来访问属性
println("the name is ${person.name}," + "the age is ${person.age}")

println person.sex

//为类动态添加方法
Person.metaClass.sexUpperCase = { -> sex.toUpperCase() }
println person.sexUpperCase()

//为类动态添加静态方法
Person.metaClass.static.createPerson = {
    name, age -> new Person(name: name, age: age)
}

def person2 = Person.createPerson('nn', 26)
println "${person2.name} and ${person2.age}"