package vroon;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AccountProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Object body = exchange.getOut().getBody();
	}

}
