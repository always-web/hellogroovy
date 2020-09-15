package variable

def x = 4
def result = null
switch (x) {
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [4, 5, 6, 'inlist']: //
        result = 'list'
        break
    case 12..30: //范围
        break
    case Integer:
        result = 'Integer'
        break
    case BigDecimal:
        result = 'BigDecimal'
        break
    default:
        result = 'none'
}

println(result)

// 对范围的for循环
def sum = 0
for (i in 0..9) {
    print(i + " ")
}
println()
//println(sum)

//对list循环
for (i in [1, 2, 3, 4, 5, 6, 7, 8, 9]) {
    print(i + " ")
}
println()

//对map循环
for (i in ['lili': 1, 'lucy': 2, 'xiaoming': 3]) {
    print(i.key + ':' + i.value + ' ')
}
println()


