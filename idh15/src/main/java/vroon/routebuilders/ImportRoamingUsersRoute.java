package vroon.routebuilders;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

import vroon.ConfigurationProvider;
import vroon.entities.RoamingUser;
import vroon.transformers.TransformRoamingUser2Canonical;

public class ImportRoamingUsersRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		String fromFile =ConfigurationProvider.GetProperty("vroon.internet.import.folder");
		fromFile += "?noop=true&fileName=" + ConfigurationProvider.GetProperty("vroon.internet.import.filename");

		//Import file and transform this to POJO
		from("file:" + fromFile)
			.unmarshal()
			.bindy(BindyType.Csv, vroon.entities.RoamingUser.class)
			.transform(new Expression() {
				public <T> T evaluate(Exchange exchange, Class<T> type) {
					if (exchange.getIn().getBody().getClass() == ArrayList.class){
						return (T)TransformRoamingUser2Canonical.toCanonicalModel(exchange.getIn().getBody(ArrayList.class));	
					}else{
						return (T)TransformRoamingUser2Canonical.toCanonicalModel(exchange.getIn().getBody(RoamingUser.class));
					}
				}
			})
			.to("direct:" + ConfigurationProvider.GetProperty("vroon.internet.import.queue") + "?block=true&timeout=5000");
	}
}
