package vroon.transformers;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import vroon.entities.CanonicalModel;

public class EnrichCrewAndInternet implements AggregationStrategy {
	private HashMap<String, CanonicalModel> hmOldX;
	
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (newExchange == null){
			return oldExchange;
		}
		hmOldX = new HashMap<String, CanonicalModel>();
		processExchange(oldExchange);
		processExchange(newExchange);
		
		oldExchange.getIn().setBody(hmOldX.values());
		
		return oldExchange;
	}
	
	private void processExchange(Exchange exchange){
		ArrayList<CanonicalModel> items = (ArrayList<CanonicalModel>)exchange.getIn().getBody();

		for(CanonicalModel item: items){
			
			addToMap(item);	
		}
	}
	
	private void addToMap(CanonicalModel model){
		if(!hmOldX.containsKey(model.userName)){
			hmOldX.put(model.userName, model);
			return;
		}
		
		//Determine to update CrewMember of InternetAccount
		CanonicalModel item = hmOldX.get(model.userName);
		if(item.CrewMember == null){
			item.CrewMember = model.CrewMember;
		}
		if(item.InternetAccount == null){
			item.InternetAccount = model.InternetAccount;
		}
		
	}

}
