package vroon;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.impl.DefaultCamelContext;

import vroon.routebuilders.*;

public class VroonEIA {
	@EndpointInject(uri = "vroon:result") 
	private Endpoint resultEndpoint; 

	
	public static void main(String[] args) {
		CamelContext context = new DefaultCamelContext();
		
		try {
			context.addRoutes(new ImportRoamingUsersRoute());
			context.addRoutes(new ImportCrewmembersRoute());
			context.addRoutes(new EnrichDataRoute());
			context.addRoutes(new ContentBasedRoute());
			context.addRoutes(new ExportInternetAccountsRoute());
			System.out.println("context.start");
			context.start();
			
			Thread.sleep(3000);
			context.stop();
			System.out.println("context.stop");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
