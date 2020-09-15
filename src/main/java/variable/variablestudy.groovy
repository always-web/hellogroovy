package variable

int x = 10
println("int 真实类型 :" + x.class)

double y = 3.14
println("double 真实类型 : "+y.class)

def x_1 = 11
println("def 声明的的 int 真实类型 :"+x_1.class)

def y_1 = 3.14
println("def 定义的小数的真实类型: "+y_1.class)

def name = 'Ondroid'
println("def 定义的字符串的真实类型: "+name.class)

x_1 = 'Test'
println("x_1 本来是数字类型,现在改成字符串类型: "+x_1.class)

println(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10))


