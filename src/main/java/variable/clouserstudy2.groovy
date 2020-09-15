package variable

/**
 * 字符串与闭包结合使用
 */

String str = 'the 2 and 3 is 5'

//each 的遍历
str.each {
    //temp -> print(temp * 2)
}

//find 来查找符合条件的第一个
println(str.find { s -> s.isNumber() })
println(str.findAll { s -> s.isNumber() })
println(str.any { s -> s.isNumber() })
println(str.every { s -> s.isNumber() })
println(str.collect { it.toUpperCase() })















