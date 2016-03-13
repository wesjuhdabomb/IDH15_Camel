package vroon;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.dataformat.BindyType;

public class VroonRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	
		// TODO Auto-generated method stub
		from("file://C:/IDH15/files/inbox?noop=true")
		.unmarshal().bindy(BindyType.Csv, vroon.entities.InternetAccount.class)
		//.to("amqp:queue:accounts");
		//from("amqp:queue:accounts")
		
		.marshal().bindy(BindyType.Csv, vroon.entities.InternetAccount.class).to("file://C:/IDH15/files/outbox");
	}

}
