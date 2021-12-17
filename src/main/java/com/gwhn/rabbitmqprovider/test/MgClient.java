package com.gwhn.rabbitmqprovider.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author banxian1804@qq.com
 * @date 2021/12/17 14:34
 */
public class MgClient {

    //生产消息
    public  void produce(String message) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try( PrintWriter printWriter = new PrintWriter(socket.getOutputStream());) {
           printWriter.println(message);
           printWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  String consume() throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
        ) {
            //消费
            out.println("CONSUME");
            out.flush();

            //重新获取新信息用于消费
            String message = in.readLine();
            return message;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
