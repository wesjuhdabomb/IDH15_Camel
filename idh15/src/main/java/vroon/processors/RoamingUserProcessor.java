package vroon.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import vroon.entities.InternetAccount;
import vroon.entities.RoamingUser;

public class RoamingUserProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		RoamingUser roamingUser = (RoamingUser)exchange.getIn().getBody();
		roamingUser.setName("SINTERKLAAS");
		exchange.getOut().setBody(roamingUser);
	}

}
