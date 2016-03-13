package idh15;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LogProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("processing: " + exchange.getIn().getBody(String.class));
	}

}
