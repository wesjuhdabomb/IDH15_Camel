package idh15;

import org.apache.camel.builder.RouteBuilder;

public class FirstRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:C:/IDH15/files/inbox?noop=true")
//		.process(new LogProcessor())
//		.bean(new Transformer(), "transformContent")
		.to("file:C:/IDH15/files/outbox");
	}

}
