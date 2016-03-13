package lesopdracht;

import org.apache.camel.builder.RouteBuilder;

public class Route2 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms://incomingMessages")
		.to("jms:outgoingMessages");
	}

}
