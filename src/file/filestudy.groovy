package file

import objects.Person

String path = '/home/hwddhome/mycode/groovy/hellogroovy/hellogroovy.iml'
def file = new File(path)
//file.eachLine { line -> println line }
def text = file.getText()
//println text

def result = file.readLines()
assert result instanceof List
//println result

def reader = file.withReader { reader ->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader

def copy(String sourcePath, String destationPath) {
    try {
        //首先创建目标文件
        def desFile = new File(destationPath)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        //开始copy
        new File(sourcePath).withReader { reader ->
            def text = reader.getText()
            desFile.withWriter { writer ->
                writer.append(text)
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def flag = copy(path, '../aa.iml')
println flag

//对象读写
def saveObject(Object obj, String path) {
    try {
        def desFile = new File(path)
        if (!desFile.exists()) {
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream { out ->
            out.writeObject(obj)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def readObject(String path) {
    def obj = null
    try {
        def file = new File(path)
        if (file == null || !file.exists()) {
            return null
        }
        //从文件中读取对象
        file.withObjectInputStream { input ->
            obj = input.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}

def f = saveObject(new Person(name: 'nnnn', age: 100), '../person.bin')
println f

def obj = (Person) readObject('../person.bin')
println("the name is ${obj.name} and the age is ${obj.age}")


