package variable

// 字符串的方法

def str = "groovy"

// 以str字符串为中心,填充字符串
println(str.center(8, 'a'))

// 在str字符串左边填充字符串
println(str.padLeft(8, 'a'))


// 字符串的比较,比较的是ascii码的大小
def str1 = "abc"
println(str1 > str)

//获取字符串指定位置的字符
println(str[0])
println(str[0..1])

//截取字符串
def str3 = 'roo'
println(str.minus(str3))
println(str - str3)

//字符串反转
println(str.reverse())

//字符串首字母大写
println(str.capitalize())

//判断字符串是否数字
println(str.isNumber())