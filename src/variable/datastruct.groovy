package variable

def list = [1, 2, 3, 4]
println(list.class)

def array = [1, 2, 4, 5] as int[]
println(array.class)

int[] array2 = [1, 2, 3, 4, 5]
println(array2.class)


// 列表的排序
def sortList = [6, -3, -1, 2, 7, 8, -10, 9, 4, 10]
//println(sortList.hashCode())
//println(sortList.sort().hashCode())
//println(sortList)
//println(sortList.sort({ a, b -> a == b ? 0 : Math.abs(a) < Math.abs(b) ? -1 : 1 }))

def stringList = ['a', 'ab', 'cde', 'dfde', 'sdfsfs']
stringList.sort({ it.size() })
println(stringList)

// 列表的查找
println(sortList.find { it % 2 == 0 })
def result = sortList.findAll { it % 2 == 0 }
println(result.toListString())
println(sortList.any { it % 2 != 0 })
println(sortList.every { it % 2 == 0 })
println(sortList.min { Math.abs(it) })
println(sortList.max { Math.abs(it) })
println(sortList.count { it % 2 == 0 })

// 列表的添加
def addList = [1, 8]
addList.add(6)
println(addList)
println(addList << 0)

// 列表的删除
addList.remove(1)
println(addList)
addList.remove((Object) 1)
println(addList)
addList.removeElement(0)
println(addList)
addList.removeAt(0)
println(addList)




