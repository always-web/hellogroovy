package variable

def name = 'a single string'
println(name.class)

def thupleName = '''one
two
three
'''
println(thupleName)
print(thupleName.class)

def name2 = 'Ondroid'
def sayHello = "h: ${name2}"
def three = "hello: ${1 + 2}"

println sayHello
println(sayHello.class)
println(three)




