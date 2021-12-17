package com.gwhn.rabbitmqprovider.test;

/**
 * @author banxian1804@qq.com
 * @date 2021/12/17 14:41
 */
public class ProduceClient {

    public static void main(String[] agrs) throws Exception{
        MgClient mgClient = new MgClient();
        mgClient.produce("Hello");
    }
}
