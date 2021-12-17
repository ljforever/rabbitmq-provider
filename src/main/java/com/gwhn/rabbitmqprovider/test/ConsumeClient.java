package com.gwhn.rabbitmqprovider.test;

/**
 * @author banxian1804@qq.com
 * @date 2021/12/17 14:47
 */
public class ConsumeClient {

    public static void main(String[] args) throws Exception {
        MgClient mgClient = new MgClient();
        String message = mgClient.consume();
        System.out.println("获取消息："+message);
    }
}
