package idh15;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import nl.avans.idh15.downloader.FilesDownloader;

public class test {

	public static void main(String[] args) {
		
		CamelContext context = new DefaultCamelContext();
		
		
		try {
			context.addRoutes(new FirstRouteBuilder());
//			context.addRoutes(new GebeurtenisssenInfoRouteBuilder());
			System.out.println("context.start");
			context.start();
			Thread.sleep(5000);
			context.stop();
			System.out.println("context.stop");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		downloadFiles();
	}
	
	private static void downloadFiles(){
		FilesDownloader downloader = new FilesDownloader();
		downloader.download("Blaat.txt");
//		downloader.download("brugopeningen.xml.gz");
//		downloader.download("incidents.xml.gz");
//		downloader.download("incidents.xml.gz");
//		downloader.download("incidents.xml.gz");
	}
}
