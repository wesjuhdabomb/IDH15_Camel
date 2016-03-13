package vroon.routebuilders;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

import vroon.ConfigurationProvider;
import vroon.entities.CrewMember;
import vroon.transformers.TransformCrewMember2Canonical;

public class ImportCrewmembersRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		String fromFile =ConfigurationProvider.GetProperty("vroon.crewing.import.folder");
		fromFile += "?noop=true&fileName=" + ConfigurationProvider.GetProperty("vroon.crewing.import.filename");

		//Import file and transform this to POJO
		from("file:" + fromFile)
			.unmarshal()
			.bindy(BindyType.Csv, vroon.entities.CrewMember.class)
			.transform(new Expression() {
				public <T> T evaluate(Exchange exchange, Class<T> type) {
					if (exchange.getIn().getBody().getClass() == ArrayList.class){
						return (T)TransformCrewMember2Canonical.toCanonicalModel(exchange.getIn().getBody(ArrayList.class));	
					}else{
						return (T)TransformCrewMember2Canonical.toCanonicalModel(exchange.getIn().getBody(CrewMember.class));
					}
					
				}
			})
			.to("direct:" + ConfigurationProvider.GetProperty("vroon.crewing.import.queue"));
	}

}
