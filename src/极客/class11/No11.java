package 极客.class11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc: XXXX
 *
 * @author Ying BG338501
 * Date: 2019/5/14
 * @version 1.0.0
 */
public class No11 extends Thread {
    private ServerSocket serverSocket;

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
/**
 * 同步阻塞式
 */
//            0表示自动绑定一个空闲端口
//            serverSocket = new ServerSocket(0);
//            while (true) {
////                accept方法阻塞等待客户端连接,
//                Socket socket = serverSocket.accept();
//                System.out.println("连接");
//                RequestHandler requestHandler = new RequestHandler(socket);
//                requestHandler.start();
//            }
            serverSocket = new ServerSocket(0);
/**
 * 线程池,减少创建,销毁线程的开销
 */
            ExecutorService executor = Executors.newFixedThreadPool(8);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("连接");
                RequestHandler requestHandler = new RequestHandler(socket);
                executor.execute(requestHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        No11 server = new No11();
        server.start();
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s + "打印"));
        }
    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
            out.println("Hello world!");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



