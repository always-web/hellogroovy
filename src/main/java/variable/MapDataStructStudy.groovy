package variable

/**
 * map 映射
 * 定义map的时候key 应该是不可变字符串或者数字
 */

def colors = [
        red  : 'ff0000',
        green: '00ff',
        blue : '000ff'
]
println(colors.getClass())

//map 索引方式
println(colors['red'])
println(colors.red)

//map 添加元素
colors.yellow = 'ddfdf'
colors.comple = 'dfsfs'
colors.dfdf = 'nnn'
println(colors)


def students = [
        1: [number: '0001', name: 'Bob', score: 55, sex: 'male'],
        2: [number: '0002', name: 'Johnny', score: 63, sex: 'female'],
        3: [number: '0003', name: 'Claire', score: 73, sex: 'female'],
        4: [number: '0004', name: 'Amy', score: 66, sex: 'male']
]

//遍历
students.each {
    st -> println("the key is ${st.key} , the value is ${st.value}")
}
println()
println()
students.each { println("the key is ${it.key} , the value is ${it.value}") }
println()
students.eachWithIndex { stu, index -> println("index is ${index}, the key is ${stu.key} , the value is ${stu.value}") }
println()
students.each { k, v -> println("the key is ${k} , the value is ${v}") }
println()
students.eachWithIndex { k, v, index -> println("the index is ${index}, the key is ${k}, the value is ${v}") }


