package jsonstudy

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import objects.Person
import org.fusesource.jansi.internal.Kernel32

def list = [new Person(name: 'name1', age: 10),
            new Person(name: 'name2', age: 20)]
def json = JsonOutput.toJson(list)
println json
println()
println JsonOutput.prettyPrint(json)

//从json字符串转换成对象
def jsonSlpuer = new JsonSlurper()
//jsonSlpuer.parse()
//jsonSlpuer.parseText()

//发送网络请求
def getNetworkData(String url) {
    //发送http请求
    def connection = new URL(url).openConnection()
    connection.setRequestMethod('GET')
    connection.connect()
    def response = connection.connect().text

    //将json转换为实体对象
    def jsonSluper = new JsonSlurper()
    return jsonSluper.parseText(response)
}