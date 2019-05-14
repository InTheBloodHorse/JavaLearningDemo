package inthebloodhorse.javassist;

import javassist.*;

import java.io.IOException;

/*
     通过javassist动态 创建/修改 类
 */
public class CreateNewClass {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("Person");

        // 创建属性
        CtField field1 = CtField.make("private Integer age;", ctClass);
        CtField field2 = CtField.make("private String name;", ctClass);
        ctClass.addField(field1);
        ctClass.addField(field2);

        // 创建方法
        CtMethod method1 = CtMethod.make("public Integer getAge(){return age;}", ctClass);
        CtMethod method2 = CtMethod.make("public void setAge(Integer age){this.age=age;}", ctClass);
        ctClass.addMethod(method1);
        ctClass.addMethod(method2);

        // 添加构造方法
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{classPool.get("java.lang.Integer"), classPool.get("java.lang.String")}, ctClass);
        // $0 代表 this, $1.....n 代表参数
        ctConstructor.setBody("{$0.age=$1;this.name=$2;}");
        ctClass.addConstructor(ctConstructor);

        ctClass.writeFile("E:/Java/EE/LearningDemo/src/inthebloodhorse/javassist/temp");

    }
}
