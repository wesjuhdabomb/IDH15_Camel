package lesopdracht;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.activemq.*;

public class MessagingOpdracht {

	public static void main(String[] args) {
		CamelContext context = new DefaultCamelContext();
		
		// connect to ActiveMQ JMS broker        
		ActiveMQConnectionFactory connectionFactory =
		    new ActiveMQConnectionFactory("tcp://192.168.43.140:61616");        
			context.addComponent("jms",
		    JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));


		try {
			//context.addRoutes(new Route1());
			//context.addRoutes(new Route2());
			context.addRoutes(new Route3());
			System.out.println("context.start");
			context.start();
			
			Thread.sleep(3000);
			context.stop();
			System.out.println("context.stop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
