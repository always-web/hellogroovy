package variable

//闭包的定义
def clouser = { name, age -> println("hello ${name} my age is ${age}") }
clouser.call('groovy', 18)

//闭包如果没有定义参数,就会有一个隐式参数 - it
def clouse1 = { println("hello ${it}") }
clouse1.call('ni hao')


int x = cal(5)
println(x)

int fab(int number) {
    int result = 1
    1.upto(number, { num -> result *= num })
    return result
}

int fab2(int number) {
    int result = 1
    number.downto(1) { num -> result *= num }
    return result
}

int cal(int number) {
    int result = 0
    number.times {
        num -> result *= num
    }
    return result
}





