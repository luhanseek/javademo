import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicProducer {

    public static void main(String [] args) throws JMSException{
        //创建连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.188.128:61616");
        //获取连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //获取session(是否启动事务，消息确认模式)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //主题对象
        Topic topic = session.createTopic("test-topic");
        //创建消息生产者
        MessageProducer producer = session.createProducer(topic);
        //创建消息
        TextMessage textMessage = session.createTextMessage("这是一段测试语句");
        //发送消息
        producer.send(textMessage);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }

}
