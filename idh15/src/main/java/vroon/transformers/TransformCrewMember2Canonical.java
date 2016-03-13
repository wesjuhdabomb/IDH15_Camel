package vroon.transformers;

import java.util.ArrayList;

import vroon.entities.CanonicalCrewMember;
import vroon.entities.CanonicalModel;
import vroon.entities.CrewMember;

public class TransformCrewMember2Canonical {
	public static ArrayList<CanonicalModel> toCanonicalModel(ArrayList<CrewMember> crewMembers){
		ArrayList<CanonicalModel> list = new ArrayList<CanonicalModel>();
		
		for(CrewMember item: crewMembers){
			CanonicalModel model = new CanonicalModel();
			model.userName = item.username;
			model.CrewMember = new CanonicalCrewMember();
			model.CrewMember.firstName = item.firstname ;
			model.CrewMember.lastName = item.lastname;
			model.CrewMember.userName = item.username;
			list.add(model);
		}
		return list;
	}
	public static ArrayList<CanonicalModel> toCanonicalModel(CrewMember crewMember){
		ArrayList<CanonicalModel> list = new ArrayList<CanonicalModel>();
		
		CanonicalModel model = new CanonicalModel();
		model.userName = crewMember.username;
		model.CrewMember = new CanonicalCrewMember();
		model.CrewMember.firstName = crewMember.firstname ;
		model.CrewMember.lastName = crewMember.lastname;
		model.CrewMember.userName = crewMember.username;
		list.add(model);
		return list;
	}
}
