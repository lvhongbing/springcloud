package com.lynn.blog.util;

//import org.springframework.amqp.core.AmqpAdmin;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
/**
 * 发送和接收消息队列
 * @author Administrator
 *
 */
public class MyBean {

	/*private final AmqpAdmin amqpAdmin;
	private final AmqpTemplate amqpTemplate;
	
	@Autowired
	public MyBean(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
		this.amqpAdmin = amqpAdmin;
		this.amqpTemplate = amqpTemplate;
	}
	
	@RabbitHandler
	@RabbitListener(queues="someQueue")
	public void processMessage(String content) {
		//消息队列消费者
		System.out.println(content);
		String obj = (String) amqpTemplate.receiveAndConvert("someQueue");
	}
	
	public void send(String content) {
		//消息队列的生产者
		amqpTemplate.convertAndSend("someQueue", content);
	}*/
}
