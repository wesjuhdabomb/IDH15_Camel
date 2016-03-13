package vroon.transformers;

import java.util.ArrayList;

import vroon.entities.CanonicalCrewMember;
import vroon.entities.CanonicalModel;
import vroon.entities.RoamingUser;

public class TransformRoamingUser2Canonical {
	public static ArrayList<CanonicalModel> toCanonicalModel(ArrayList<RoamingUser> roamingUsers){
		ArrayList<CanonicalModel> list = new ArrayList<CanonicalModel>();
		
		for(RoamingUser item: roamingUsers){
			CanonicalModel model = new CanonicalModel();
			model.userName = item.username;
			model.InternetAccount = new CanonicalCrewMember();
			model.InternetAccount.firstName = item.firstname;
			model.InternetAccount.lastName = item.lastname;
			model.InternetAccount.userName = item.username;
			list.add(model);
		}
		return list;
	}

	public static ArrayList<CanonicalModel> toCanonicalModel(RoamingUser roamingUser){
		ArrayList<CanonicalModel> list = new ArrayList<CanonicalModel>();
		
		CanonicalModel model = new CanonicalModel();
		model.userName = roamingUser.username;
		model.InternetAccount = new CanonicalCrewMember();
		model.InternetAccount.firstName = roamingUser.firstname;
		model.InternetAccount.lastName = roamingUser.lastname;
		model.InternetAccount.userName = roamingUser.username;
		list.add(model);
		return list;
	}
	
}
