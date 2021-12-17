package com.gwhn.rabbitmqprovider.test;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author banxian1804@qq.com
 * @date 2021/12/16 8:14
 */
public class Broker {

    /**队列存储消息的最大数量*/
    private final static int MAX_SIZE = 3;

    /**保存消息数据的容器*/
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);


    public static void produce(String msg){
        if(messageQueue.offer(msg)){
            System.out.println("成功向消息处理中心投递消息:"+msg+",当前暂存的消息数量是:"+messageQueue.size());
        }else {
            System.out.println("消息处理中心饱和");
        }
        System.out.println("===================");
    }

    public static String consume(){
        String msg = messageQueue.poll();
        if(msg !=null){
            //消条件满足，从消息容器中取出1条信息
            System.out.println("已消费信息:"+msg+",当前暂存的消息数:"+messageQueue.size());
        }else {
            System.out.println("消息处理中心暂无消息可供消费");
        }
        System.out.println("===================");
        return msg;
    }
}
