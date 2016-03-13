package nl.avans.idh15.downloader;
import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.*;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ProcessorDefinition;

import idh15.FileProcessor;


public class FilesDownloader {
	private String _sourceUrl = "http://opendata.ndw.nu/brugopeningen.xml.gz"; //"file://infiles/?delete=true";//"http://opendata.ndw.nu/";
	private String _destinationFolder = "file://outfiles";
	
	
	public void download(String fileName){
		CamelContext context = new DefaultCamelContext();
		final FileProcessor fileProcessor = new FileProcessor();
		final ProducerTemplate template = context.createProducerTemplate();
		 

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		
		try {
			context.setStreamCaching(true);
			
			context.addRoutes(new RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					
					Exchange exchange = template.send("http://localhost:16000/files/Testje.txt", new Processor() {
				         public void process(Exchange exchange) throws Exception {
//				             exchange.getIn().setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http.HttpMethods.GET));
				        	 				         }
				});
				Message out = exchange.getOut();
				Integer responseCode = out.getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class);

				System.out.println("ResponseCode: " +responseCode);
//					from("direct:start")
//				    .to("http://www.google.com")
//				    .setHeader("CamelFileName", constant("message.html")).to("file:outfiles/google");

//					from("direct:start").streamCaching().process(fileProcessor).to("file:infiles/test.txt");
				}
			});
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
//			e1.printStackTrace();
		}
		try {
			
			context.start();
			System.out.println("Context started");
			Thread.sleep(2000);
			context.stop();
			System.out.println("Context stopped");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}	
		System.out.println("Done");
	}
}
