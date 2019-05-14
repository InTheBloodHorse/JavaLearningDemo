package inthebloodhorse.javassist;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通过 javassist 手动实现 aop
public class Aop {
    public static void doAop() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("import java.util.Date;");
        CtClass ctClass = classPool.get("inthebloodhorse.javassist.TestClass");
        CtMethod ctMethod = ctClass.getDeclaredMethod("add", new CtClass[]{classPool.get("java.lang.Integer"), classPool.get("java.lang.Integer")});
        ctMethod.insertBefore("long time1 = new java.util.Date().getTime();System.out.println(time1);");
        ctMethod.insertAfter("long time1 = new java.util.Date().getTime();System.out.println(time1);");
        // 通过反射调用新的方法
        Class clazz = ctClass.toClass();
        Object o = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("add", Integer.class, Integer.class);
        Object result = method.invoke(o, 20, 30);
        System.out.println("代码返回的结果为:" + result);
    }

    public static void main(String[] args) throws NotFoundException, CannotCompileException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        doAop();
    }
}