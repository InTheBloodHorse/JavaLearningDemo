package inthebloodhorse.dynamiccompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunTimeClass {
    public static void main(String[] args) throws IOException {
        String classPath = "E:/Java/EE/LearningDeom/src/inthebloodhorse/copy/Hello.java";
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null, null, null, classPath);

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -cp E:/Java/EE/LearningDeom/src/inthebloodhorse/copy Hello");
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String response = null;
        while ((response = reader.readLine()) != null) {
            System.out.println(response);
        }
    }
}
