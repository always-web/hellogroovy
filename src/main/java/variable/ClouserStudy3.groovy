package variable

/**
 * 闭包的三个重要变量: this owner,delegate
 */

def srciptClouser = {
    println("scriptClouser this:" + this) //代表闭包定义处的类
    println("scriptClouser owner:" + owner) // 代表闭包定义处的类或者对象
    println("scriptClouser delegate:" + delegate) // 任意一个第三方对象,但是它有一个默认值与owner一致
}
srciptClouser.call()

//相当于定义了一个内部类
class Person {
    def static classClouser = {
        println("classClouser this:" + this)
        println("classClouser owner:" + owner)
        println("classClouser delegate:" + delegate)
    }

    def static say() {
        def methodClouser = {
            println("methodClouser this:" + this)
            println("methodClouser owner:" + owner)
            println("methodClouser delegate:" + delegate)
        }
        methodClouser.call()
    }
}

Person.classClouser.call()
Person.say()
println()

//闭包中定义闭包
def nestClouser = {
    def innerClouser = {
        println("innerClouser this:" + this)
        println("innerClouser owner:" + owner)
        println("innerClouser delegate:" + delegate)
    }
    innerClouser.call()
}
nestClouser.call()

/*
总结:
如果在类或方法中定义闭包,并且使用 this , owner , delegate ,则这3个值都是一样的是,都是指向最近的类或对象
如果在闭包中的闭包使用这3个变量,this 指向的是最外层的对象,也就是这个脚本本身; owner 和 delegate 还是一样指向最近的类或者对象
 */

/**
 * 闭包的委托策略
 */

class Student {
    String name
    def pretty = { "my name is ${name}" }

    @Override
    String toString() {
        pretty.call()
    }
}

class Teacher {
    String name
}

def stu = new Student(name: 'Sarash')
def tea = new Teacher(name: 'Ondroid')
println(stu.toString())

stu.pretty.delegate = tea
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println(stu.toString())