package com.effort.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2017/9/14.
 */
public class MyServer {


    private static final String SERVER_IP = "127.0.0.1"; //服务器IP

    private static final int SERVER_PORT = 10057; //服务器端口号

    private static final int MAX_BTYE = 1024; //最大处理字节数

    private DatagramSocket serverSocket; //UDP使用DatagramSocket发送数据包

    private static final Logger log = LoggerFactory.getLogger(MyServer.class);

    /**
     * 启动服务器
     *
     * @param serverIp
     * 				服务器的IP地址
     * @param serverPort
     * 				服务器端口地址
     */
    public void startServer(String serverIp,int serverPort){
        try {
            //创建DatagramSocket
            InetAddress serverAddr = InetAddress.getByName(serverIp);
            serverSocket = new DatagramSocket(serverPort,serverAddr);
            //创建接受数据的对象
            byte[] recvBuf  = new byte[MAX_BTYE];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);
            //死循环，一直运行服务器
            while(true){
                //接收数据，会在这里阻塞，直到有数据到来
                try {
                    serverSocket.receive(recvPacket);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
                //拿到対端的ip和端口
                InetAddress clientAddr = recvPacket.getAddress();
                int clientPort = recvPacket.getPort();
                //回传数据
                String upperString = recvStr.toUpperCase();
                byte[] sendBuf = upperString.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, clientAddr, clientPort);
                try {
                    serverSocket.send(sendPacket);
                    log.info("接收到的信息是："+recvStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(null!=serverSocket){
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
