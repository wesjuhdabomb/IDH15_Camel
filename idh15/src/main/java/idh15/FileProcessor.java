package idh15;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Object body = exchange.getOut().getBody();
		
		System.out.println("Bloody hell it works!:" + body.toString());
	}

}
