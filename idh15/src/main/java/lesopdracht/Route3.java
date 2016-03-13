package lesopdracht;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class Route3 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:outgoingMessages").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("***** received message: " + exchange.getIn().getHeader("CamelFileName"));                       	
				}
		});
	}

}
