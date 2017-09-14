package com.effort.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/9/9.
 */
public class MyClient {

    private DatagramSocket clientSocket;
    private static final int MAX_BYTES = 1024;//最多处理1024个字符
    private static final String SERVER_IP = "127.0.0.1"; //服务器IP
    private static final int SERVER_PORT = 10057; //服务器端口号
    private static final Logger log = LoggerFactory.getLogger(MyClient.class);


    public String clientServer(String serverIp, int serverPort, String str){
        String recvStr = "";
        //创建UDP Socket
        try {
            clientSocket = new DatagramSocket();
            //向服务器发送数据
            byte[] sendBuf;
            sendBuf = str.getBytes();
            InetAddress serverAddr = InetAddress.getByName(serverIp);
            DatagramPacket sendPacket = new DatagramPacket(sendBuf,sendBuf.length,serverAddr,serverPort);
            clientSocket.send(sendPacket);
            //接受服务器的响应
            byte[] recvBuf = new byte[MAX_BYTES];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);
            clientSocket.receive(recvPacket);
            //显示响应
            recvStr = new String(recvPacket.getData() , 0 ,recvPacket.getLength());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != clientSocket) {
                clientSocket.close();
                clientSocket = null;
            }
        }
        return recvStr;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String str = new MyClient().clientServer(SERVER_IP,SERVER_PORT,"Fucking man");
                log.info(str);
            }
        }, 0, 4 * 1000);
        timer.cancel();
    }
}
