package vroon.entities;

public class CanonicalModel {
	public String userName;
	public String getStatus(){
		if (CrewMember == null && InternetAccount != null){
			return CrewMemberStatus.Deleted.toString();
		}
		
		if (CrewMember != null && InternetAccount == null){
			System.out.println("New CrewMember");
			return CrewMemberStatus.New.toString();
		}

		return CrewMemberStatus.Updated.toString();
	};

	public CanonicalCrewMember CrewMember;
	public CanonicalCrewMember InternetAccount;
}
