package variable

// 单引号字符串没有格式
def name = 'a single string'
println(name)
println(name.class)

// 三引号字符串可以有格式
def thupleName = '''one
two
three
'''
println(thupleName)
print(thupleName.class)

// 双引号字符串是可扩展字符串
def name2 = 'Ondroid'
def sayHello = "h: ${name2}"
def three = "hello: ${1 + 2}"

println sayHello
println(sayHello.class)
println(three)




