package vroon.transformers;

import java.util.ArrayList;
import java.util.Collection;

import vroon.entities.*;

public class TransformCanonical2InternetAccount {
	public static ArrayList<InternetAccount> Transform(Collection<CanonicalModel> models){
		ArrayList<InternetAccount> accounts = new ArrayList<InternetAccount>();
		
		for(CanonicalModel item: models){
			accounts.add(item.CrewMember != null 
					? MapAccount(item.CrewMember)
					: MapAccount(item.InternetAccount));
		}
		
		return accounts;
	}
	
	public static InternetAccount Transform(CanonicalModel model){
		System.out.println("InternetAccountTransform");
		
		return model.CrewMember != null 
				? MapAccount(model.CrewMember)
				: MapAccount(model.InternetAccount);
	}	
	
	private static InternetAccount MapAccount(CanonicalCrewMember crew){
		InternetAccount account = new InternetAccount();
		account.firstname = crew.firstName;
		account.lastname = crew.lastName;
		account.username = crew.userName;
		return account;
	}
}
