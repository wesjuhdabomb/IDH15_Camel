package vroon.routebuilders;

import org.apache.camel.builder.RouteBuilder;

import vroon.ConfigurationProvider;
import vroon.transformers.EnrichCrewAndInternet;

public class EnrichDataRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		//from("direct:start")
		from("direct:" + ConfigurationProvider.GetProperty("vroon.crewing.import.queue"))
		.pollEnrich("direct:" + ConfigurationProvider.GetProperty("vroon.internet.import.queue"), new EnrichCrewAndInternet())
		.to("direct:" + ConfigurationProvider.GetProperty("vroon.integration.pollenrich.queue"));
	}

}
