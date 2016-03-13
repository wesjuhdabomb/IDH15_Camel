package lesopdracht;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;


public class MyMessageRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/IDH15/files/inbox?noop=true")
		.to("jms://incomingMessages");
		
		from("jms://incomingMessages")
		.to("jms:outgoingMessages");
		
		from("jms:outgoingMessages").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("***** received message: " + exchange.getIn().getHeader("CamelFileName"));                       	
				}
		});

	}

}
