package vroon.routebuilders;

import org.apache.camel.builder.RouteBuilder;

import vroon.ConfigurationProvider;

public class ContentBasedRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:" + ConfigurationProvider.GetProperty("vroon.integration.pollenrich.queue") + "?block=true&timeout=5000")
		.split(body())
		.choice()
			.when(simple("${in.body.getStatus()} == 'New'"))
				.to("direct:" + ConfigurationProvider.GetProperty("vroon.integration.newuser.queue")+ "?block=true&timeout=5000")
			.when(simple("${in.body.getStatus()} == 'Updated'"))
				.to("direct:" + ConfigurationProvider.GetProperty("vroon.integration.updateduser.queue")+ "?block=true&timeout=5000")
			.when(simple("${in.body.getStatus()} == 'Deleted'"))
				.to("direct:" + ConfigurationProvider.GetProperty("vroon.integration.deleteduser.queue")+ "?block=true&timeout=5000")
			.otherwise().to("mock:result")
		;
	}
	
}
