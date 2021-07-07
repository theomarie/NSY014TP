
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

class Producer{
	public static void main(String [] args) throws InterruptedException{
		ConnectionFactory connexionFactory;
		Connection connexion = null;
		Session session;
		Destination destination;
		MessageProducer msgProducer;

		connexionFactory = new ActiveMQConnectionFactory(
						ActiveMQConnection.DEFAULT_USER,
						ActiveMQConnection.DEFAULT_PASSWORD,
						"tcp://localhost:61616"
						);
		try{
			connexion = connexionFactory.createConnection();
			connexion.start();
			session = connexion.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("cours-nys014");
			msgProducer = session.createProducer(destination);
			msgProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			sendMsg(session,msgProducer);
			session.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(null != connexion)
				try {
					connexion.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
		}
	}

	public static void sendMsg(Session session,MessageProducer msgProducer) throws JMSException{
		String[] enseignements = new String[] { "RMI", "MOM by Alexis", "SOAP", "REST","SOCKET" };
		for(String enseignement : enseignements){
			TextMessage txtMsg = session.createTextMessage(enseignement);
			System.out.println("Message envoyé : " + txtMsg.getText());
			msgProducer.send(txtMsg);
		}
	}
}