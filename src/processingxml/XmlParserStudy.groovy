package processingxml

import groovy.util.slurpersupport.GPathResult
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

def text = '''
    <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''

// XmlSlurper
def list = new XmlSlurper().parseText(text)
assert list instanceof GPathResult
//println list.technology.name.getClass()
assert list.technology.name == 'Groovy'

//XmlParser
def list1 = new XmlParser().parseText(text)
assert list1 instanceof Node
assert list1.technology.name.text() == 'Groovy'

//DOMCategory
def CAR_RECORDS = '''
<records>
  <car name='HSV Maloo' make='Holden' year='2006'>
    <country>Australia</country>
    <record type='speed'>Production Pickup Truck with speed of 271kph</record>
  </car>
  <car name='P50' make='Peel' year='1962'>
    <country>Isle of Man</country>
    <record type='size'>Smallest Street-Legal Car at 99cm wide and 59 kg in weight</record>
  </car>
  <car name='Royale' make='Bugatti' year='1931'>
    <country>France</country>
    <record type='price'>Most Valuable Car at $15 million</record>
  </car>
</records>
'''
def reader = new StringReader(CAR_RECORDS)
def doc = DOMBuilder.parse(reader)
def records = doc.documentElement
use(DOMCategory) {
    assert records.car.size() == 3
}


//GPath
final String books = '''
    <response version-api="2.0">
        <value>
            <books>
                <book available="20" id="1">
                    <title>Don Quixote</title>
                    <author id="1">Miguel de Cervantes</author>
                </book>
                <book available="14" id="2">
                    <title>Catcher in the Rye</title>
                   <author id="2">JD Salinger</author>
               </book>
               <book available="13" id="3">
                   <title>Alice in Wonderland</title>
                   <author id="3">Lewis Carroll</author>
               </book>
               <book available="5" id="4">
                   <title>Don Quixote</title>
                   <author id="4">Miguel de Cervantes</author>
               </book>
           </books>
       </value>
    </response>
'''
def respone = new XmlSlurper().parseText(books)
def authorResult = respone.value.books.book[0].author
println authorResult.getClass()
//assert authorResult instanceof GPathResult
assert authorResult.text() == 'Miguel de Cervantes'

//获取id
def book = respone.value.books.book[0]
def bookAuthorId1 = book.@id
def bookAuthorId2 = book['@id']
assert bookAuthorId1 == '1'
assert bookAuthorId1.toInteger() == 1
assert bookAuthorId1 == bookAuthorId2

//使用 GPath 遍历 tree ,using * (aka children())
// .'*' could be replaced by .children() like breadthFirst()
def catcherInTheRye = respone.value.books.'*'.find { node ->
    node.name() == 'book' && node.@id == '2'
}
assert catcherInTheRye.title.text() == 'Catcher in the Rye'

// using **,depthFirst()
def bookId = respone.'**'.find { book1 ->
    book1.author.text() == 'Lewis Carroll'
}.@id
assert bookId == 3

def titles = respone.'**'.findAll { node -> node.name() == 'title' }*.text()
assert titles.size() == 4
