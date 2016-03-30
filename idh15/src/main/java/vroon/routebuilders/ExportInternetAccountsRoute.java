package vroon.routebuilders;

import java.util.Collection;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

import vroon.ConfigurationProvider;
import vroon.entities.CanonicalModel;
import vroon.transformers.TransformCanonical2InternetAccount;

public class ExportInternetAccountsRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		String exportFolder = ConfigurationProvider.GetProperty("vroon.internet.export.folder");
		String exportNewUsers =exportFolder + "?autoCreate=true&fileExist=Append&fileName=" + ConfigurationProvider.GetProperty("vroon.internet.export.newUsersFilename");
		String exportUpdatedUsers =exportFolder + "?autoCreate=true&fileExist=Append&fileName=" + ConfigurationProvider.GetProperty("vroon.internet.export.updatedUsersFilename");
		String exportDeletedUsers =exportFolder + "?autoCreate=true&fileExist=Append&fileName=" + ConfigurationProvider.GetProperty("vroon.internet.export.deletedUsersFilename");
		
		//Export New Users
		from("direct:" + ConfigurationProvider.GetProperty("vroon.integration.newuser.queue") + "?block=true&timeout=5000")
		.transform(new Expression() {
			
			public <T> T evaluate(Exchange exchange, Class<T> type) {
				if (exchange.getIn().getBody().getClass() == Collection.class){
					return (T) TransformCanonical2InternetAccount.Transform(exchange.getIn().getBody(Collection.class));
				}
				
				return (T) TransformCanonical2InternetAccount.Transform(exchange.getIn().getBody(CanonicalModel.class));
			}
		})
		.marshal().bindy(BindyType.Csv, vroon.entities.InternetAccount.class)
		.to("file:" + exportNewUsers);
		
		//Export Updated Users
		from("direct:" + ConfigurationProvider.GetProperty("vroon.integration.updateduser.queue") + "?block=true&timeout=5000")
		.transform(new Expression() {
			
			public <T> T evaluate(Exchange exchange, Class<T> type) {
				if (exchange.getIn().getBody().getClass() == Collection.class){
					return (T) TransformCanonical2InternetAccount.Transform(exchange.getIn().getBody(Collection.class));
				}
				
				return (T) TransformCanonical2InternetAccount.Transform(exchange.getIn().getBody(CanonicalModel.class));
			}
		})
		.marshal().bindy(BindyType.Csv, vroon.entities.InternetAccount.class)
		.to("file:" + exportUpdatedUsers);
		
		//Export Deleted Users
		from("direct:" + ConfigurationProvider.GetProperty("vroon.integration.deleteduser.queue") + "?block=true&timeout=5000")
		.transform(new Expression() {
			
			public <T> T evaluate(Exchange exchange, Class<T> type) {
				if (exchange.getIn().getBody().getClass() == Collection.class){
					return (T) TransformCanonical2InternetAccount.Transform(exchange.getIn().getBody(Collection.class));
				}
				
				return (T) TransformCanonical2InternetAccount.Transform(exchange.getIn().getBody(CanonicalModel.class));
			}
		})
		.marshal().bindy(BindyType.Csv, vroon.entities.InternetAccount.class)
		.to("file:" + exportDeletedUsers);
		
	}

}
