package inthebloodhorse.annotation.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class solve {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("inthebloodhorse.annotation.orm.Student");
        // 类注解
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        System.out.println(Arrays.asList(annotations));
        SqlTable sqlTable = (SqlTable) clazz.getDeclaredAnnotation(SqlTable.class);
        System.out.println(sqlTable.value());
        // 属性注解
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            SqlField sqlField = field.getDeclaredAnnotation(SqlField.class);
            System.out.println(sqlField.columnName() + " " + sqlField.type());
        }
    }
}
