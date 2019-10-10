package jsonstudy

final String xml = '''
<beans>

  <bean id="person" class="org.springframework.beans.TestBean" scope="prototype">
    <property name="age" value="10"/>
    <property name="spouse">
      <bean class="org.springframework.beans.TestBean">
        <property name="age" value="11"/>
      </bean>
    </property>
  </bean>

  <bean id="theAge"
        class="org.springframework.beans.factory.config.PropertyPathFactoryBean">
    <property name="targetBeanName" value="person"/>
    <property name="propertyPath" value="spouse.age"/>
  </bean>

</beans>
'''

//groovy 解析xml
def xmlSluper = new XmlSlurper()
def response = xmlSluper.parseText(xml)
println response.beans.bean[0].@id