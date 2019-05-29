package inthebloodhorse.myjedis;

import java.io.IOException;
import java.net.Socket;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/5/2718:19
 */
public class MyJedis {

    /**
     * @return java.lang.String
     * @descrption: redis设置key，redis的协议为
     * *n $op[i]len op[i]operator,i<n;
     * @params [key, value]
     * @author 1ni
     * @time 2019/5/28 9:38
     */
    public static String set(String key, String value) throws IOException {
        String command = getCommand(CommandEnum.SET, key, value);
        String response = execute(command);
        return response;
    }

    public static String get(String key) throws IOException {
        String command = getCommand(CommandEnum.GET, key);
        String response = execute(command);
        return response;
    }

    private static String getCommand(CommandEnum commandEnum, String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*" + (args.length + 1)).append("\r\n");
        stringBuilder.append("$" + commandEnum.getCommand().length()).append("\r\n");
        stringBuilder.append(commandEnum.getCommand()).append("\r\n");
        for (String str : args) {
            // 使用getBytes是避免中文出现长度不一致问题
            // 所以先转成byte数组
            stringBuilder.append("$" + str.getBytes().length).append("\r\n");
            stringBuilder.append(str).append("\r\n");
        }
        return stringBuilder.toString();
    }

    private static String execute(String command) throws IOException {

        Socket socket = new Socket("127.0.0.1", 6379);
        socket.getOutputStream().write(command.getBytes());
        byte[] response = new byte[2048];
        socket.getInputStream().read(response);
        return new String(response);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(MyJedis.set("1ni", "good"));
        System.out.println(MyJedis.get("1ni"));
    }
}
