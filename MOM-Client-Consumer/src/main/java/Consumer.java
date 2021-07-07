
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


class Consumer implements javax.jms.ExceptionListener{
	public static void main(String [] args) throws InterruptedException{
		ConnectionFactory connexionFactory;
		Connection connexion = null;
		Session session;
		Destination destination;
		MessageConsumer consumer;

		connexionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD,
				"tcp://localhost:61616");
		try {
			connexion = connexionFactory.createConnection();
			connexion.start();
			session = connexion.createSession(Boolean.FALSE,
								Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("cours-nys014");
			consumer = session.createConsumer(destination);

			while (true) {
				TextMessage message = (TextMessage) consumer.receive(1000);
				if (null != message) {
					System.out.println("Message reçu : " + message.getText());
				} else {
					System.out.println("***************************** FIN - MOM - LEROUX ALEXIS *****************************");
				break;
				}	
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connexion)
					connexion.close();
			} catch (Throwable ignore) {
		}
	  }
	}

	public synchronized void onException(JMSException arg0) {
		System.out.println("Exception JMS.  Fermeture du client.");
	}	
}