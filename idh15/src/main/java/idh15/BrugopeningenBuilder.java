package idh15;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class BrugopeningenBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	       from("timer://runOnce?repeatCount=1")
	        .to("http://opendata.ndw.nu/brugopeningen.xml.gz")
	           .setHeader(Exchange.FILE_NAME, constant("brugopeningen.xml"))
	           .unmarshal().gzip()
	           .to("file:C:/IDH15/files");
		
	}

}
