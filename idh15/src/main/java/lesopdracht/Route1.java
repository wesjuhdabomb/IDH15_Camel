package lesopdracht;

import org.apache.camel.builder.RouteBuilder;

public class Route1 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/IDH15/files/inbox?noop=true")
		.to("jms://incomingMessages");
	}

}
