package objects

/**
 * groovy 中默认都是public,继承于GroovyObject类
 */
class Person implements Action ,Serializable{
    String name
    int age

    void increaseAge(int years) {
        this.age += years
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }
}
