package inthebloodhorse.scriptrun;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        // 所有的变量都加载到了上下文里，所以java和js都可以读取变量
        String code = "var a = 1;print(a)";
        scriptEngine.eval(code);
        scriptEngine.put("a", "2");
        System.out.println(scriptEngine.get("a"));

        // 函数调用
        String function = "function add(a,b){return a+b;};";
        scriptEngine.eval(function);
        Invocable invocable = (Invocable) scriptEngine;
        Object result = invocable.invokeFunction("add", new Object[]{10, 30});
        System.out.println(result);

        // 执行js文件
        String path = System.getProperty("user.dir") + "/src/a.js";
        FileReader fileReader = new FileReader(path);
        scriptEngine.eval(fileReader);
        fileReader.close();
    }
}
