package inthebloodhorse.mytomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author InTheBloodHorse
 * @description: TODO
 * @date 2019/5/28 18:17
 */
public class WebService {
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void run(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("服务器启动成功");
        while (!server.isClosed()) {
            Socket request = server.accept();
            threadPool.execute(() -> {
                try {
                    System.out.println("收到请求");
                    InputStream inputStream = request.getInputStream();
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(inputStream, "utf-8");
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String msg;
                    StringBuilder requestInfo = new StringBuilder();
                    while ((msg = reader.readLine()) != null) {
                        if (msg.length() == 0) {
                            break;
                        }
                        requestInfo.append(msg).append("\r\n");
                    }
                    System.out.println(requestInfo.toString());

                    // 返回 response
                    byte[] response = "HelloWorld".getBytes();
                    OutputStream outputStream = request.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK \r\n".getBytes());
                    outputStream.write("Content-Type: text/plain;charset=UTF-8 \r\n".getBytes());
                    outputStream.write(("Content length: " + response.length + "\r\n").getBytes());
                    outputStream.write("\r\n".getBytes()); // 空行 区分响应头和响应实体
                    outputStream.write(response);
                    outputStream.flush();
                    System.out.println("---------end\n");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        request.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
